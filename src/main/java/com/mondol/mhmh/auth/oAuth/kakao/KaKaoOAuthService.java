package com.mondol.mhmh.auth.oAuth.kakao;


import com.mondol.mhmh.auth.jwt.JwtUtil;
import com.mondol.mhmh.auth.jwt.TokenRs;
import com.mondol.mhmh.auth.oAuth.LoginType;
import com.mondol.mhmh.exception.CustomException;
import com.mondol.mhmh.user.repository.UserRepository;
import com.mondol.mhmh.user.schema.UserEntity;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
@Log4j2
public class KaKaoOAuthService {

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.provider.kakao.token-uri}")
    private String KAKAO_TOKEN_URL;

    @Value("${spring.security.oauth2.client.provider.kakao.user-info-uri}")
    private String KAKAO_USER_INFO_URL; // 사용자 정보 가져오기

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public ResponseEntity<TokenRs> getAccessToken(String authorizationCode, HttpServletRequest request) {
        String redirectUri = "";
        try {
            RestTemplate restTemplate = new RestTemplate();
            String host = request.getRequestURI();

            log.debug(host+ " :request host");
            if (host.contains("localhost:5173")) {
                // 로컬 환경
                redirectUri = "http://localhost:5173/login/kakao";
            } else if (host.contains("localhost:8080")) {
                redirectUri = "http://localhost:8080/login/oauth2/code/kakao";
            } else if(host.contains("mh-mh.vercel.app")){
                // 프로덕션 환경
                redirectUri = "https://mh-mh.vercel.app/login/kakao";
            } else if(host.contains("mhmh-backend.fly.dev")) {
                redirectUri = "https://mhmh-backend.fly.dev/login/oauth2/code/kakao/test";
            }else {
                throw new CustomException("허용된 host가 아닙니다.");
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> bodyParams = new LinkedMultiValueMap<>();
            bodyParams.set("grant_type", "authorization_code");
            bodyParams.set("client_id", clientId);
            bodyParams.set("redirect_uri", redirectUri);
            bodyParams.set("code", authorizationCode);

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(bodyParams, headers);

            // 카카오 토큰 요청
            ResponseEntity<KakaoTokenBody> response = restTemplate.postForEntity(KAKAO_TOKEN_URL, requestEntity, KakaoTokenBody.class);

            KakaoUserInfoBody userInfo = getInfo(response.getBody().getAccessToken());

            String id = LoginType.KAKAO.getIdPre() + userInfo.getId();
            if (userRepository.findById(id).isEmpty()) {
                userRepository.save(UserEntity.from(id, userInfo.getName(), userInfo.getEmail(), userInfo.getProfileUrl(), LoginType.KAKAO));
            }

            String accessToken = jwtUtil.generateAccessToken(id, userInfo.getEmail());
            String refreshToken = jwtUtil.generateRefreshToken(id);

            return new ResponseEntity<>(TokenRs.of(accessToken, refreshToken), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            // 클라이언트 요청 문제 (4xx)
            System.err.println("여기 에러났어유..");
            return new ResponseEntity<>(TokenRs.of(e.getMessage(), "redirect uri: "+redirectUri +"  host:" +request.getRequestURI()), HttpStatus.BAD_REQUEST);
//            throw new CustomException("클라이언트 요청 에러: " + e.getResponseBodyAsString(), e);
        } catch (HttpServerErrorException e) {
            // 서버 문제 (5xx)
            return new ResponseEntity<>(TokenRs.of(e.getMessage(), null), HttpStatus.BAD_REQUEST);
//            throw new CustomException("서버 에러: " + e.getResponseBodyAsString(), e);
        } catch (RestClientException e) {
            return new ResponseEntity<>(TokenRs.of(e.getMessage(), null), HttpStatus.BAD_REQUEST);
            // 기타 RestTemplate 에러
//            throw new CustomException("RestTemplate 처리 중 에러: " + e.getMessage(), e);
        } catch (Exception e) {
            return new ResponseEntity<>(TokenRs.of(e.getMessage(), null), HttpStatus.SERVICE_UNAVAILABLE);
            // 기타 예외
//            throw new CustomException("예기치 못한 에러 발생: " + e.getMessage(), e);
        }
    }
    private String createCookie(String name, String value, int maxAge, boolean httpOnly) {
        StringBuilder cookie = new StringBuilder();
        cookie.append(name).append("=").append(value).append(";");
        cookie.append("Max-Age=").append(maxAge).append(";");
        cookie.append("Path=/;");
        cookie.append("Domain=localhost;");
//        cookie.append("Secure;");
        cookie.append("SameSite=Lax;");
        if (httpOnly) {
            cookie.append(" HttpOnly;");
        }
        return cookie.toString();
    }

    private KakaoUserInfoBody getInfo(String token) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.set("Authorization", "Bearer " + token);

            HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<KakaoUserInfoBody> userResult = restTemplate.exchange(
                    KAKAO_USER_INFO_URL,
                    HttpMethod.GET,
                    kakaoProfileRequest,
                    KakaoUserInfoBody.class
            );

            return userResult.getBody();
        } catch (HttpClientErrorException e) {
            throw new CustomException("클라이언트 요청 에러 (사용자 정보): " + e.getResponseBodyAsString(), e);
        } catch (HttpServerErrorException e) {
            throw new CustomException("서버 에러 (사용자 정보): " + e.getResponseBodyAsString(), e);
        } catch (RestClientException e) {
            throw new CustomException("RestTemplate 처리 중 에러 (사용자 정보): " + e.getMessage(), e);
        } catch (Exception e) {
            throw new CustomException("예기치 못한 에러 발생: " + e.getMessage(), e);
        }
    }

}
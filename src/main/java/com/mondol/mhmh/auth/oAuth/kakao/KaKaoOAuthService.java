package com.mondol.mhmh.auth.oAuth.kakao;


import com.mondol.mhmh.auth.jwt.JwtUtil;
import com.mondol.mhmh.auth.jwt.TokenRs;
import com.mondol.mhmh.auth.oAuth.LoginType;
import com.mondol.mhmh.exception.CustomException;
import com.mondol.mhmh.user.repository.UserRepository;
import com.mondol.mhmh.user.schema.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RequiredArgsConstructor
@Service
public class KaKaoOAuthService {

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String redirectUri;

    private final String KAKAO_TOKEN_URL = "https://kauth.kakao.com/oauth/token";
    private final String KAKAO_USER_INFO_URL = "https://kapi.kakao.com/v2/user/me"; // 사용자 정보 가져오기

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public ResponseEntity<Void> getAccessToken(String authorizationCode) {
        try {
            RestTemplate restTemplate = new RestTemplate();

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

            URI redirectUri = URI.create("https://localhost:5173");

            // 헤더 설정
            HttpHeaders headers2 = new HttpHeaders();
            headers2.add("Access-Control-Allow-Credentials", "true");
            headers2.setLocation(redirectUri); // 리디렉션 URL 설정
            headers2.add(HttpHeaders.SET_COOKIE, createCookie("accessToken", accessToken, 3600, false));
            headers2.add(HttpHeaders.SET_COOKIE, createCookie("refreshToken", refreshToken, 604800, false));

            return new ResponseEntity<>(headers2, HttpStatus.FOUND);
        } catch (HttpClientErrorException e) {
            // 클라이언트 요청 문제 (4xx)
            throw new CustomException("클라이언트 요청 에러: " + e.getResponseBodyAsString(), e);
        } catch (HttpServerErrorException e) {
            // 서버 문제 (5xx)
            throw new CustomException("서버 에러: " + e.getResponseBodyAsString(), e);
        } catch (RestClientException e) {
            // 기타 RestTemplate 에러
            throw new CustomException("RestTemplate 처리 중 에러: " + e.getMessage(), e);
        } catch (Exception e) {
            // 기타 예외
            throw new CustomException("예기치 못한 에러 발생: " + e.getMessage(), e);
        }
    }
    private String createCookie(String name, String value, int maxAge, boolean httpOnly) {
        StringBuilder cookie = new StringBuilder();
        cookie.append(name).append("=").append(value).append(";");
        cookie.append("Max-Age=").append(maxAge).append(";");
        cookie.append("Path=/;");
        cookie.append("Domain=localhost:5173;");
        cookie.append("Secure;");
        cookie.append("SameSite=None;");
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
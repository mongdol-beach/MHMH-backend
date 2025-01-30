package com.mondol.mhmh.auth.oAuth.naver;

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
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
@Log4j2
public class NaverOAuthService {
    @Value("${spring.security.oauth2.client.registration.naver.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.provider.naver.token-uri}")
    private String NAVER_TOKEN_URL;

    @Value("${spring.security.oauth2.client.provider.naver.user-info-uri}")
    private String NAVER_USER_INFO_URL;

    @Value("${oauth2.state}")
    private String state;


    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public TokenRs getAccessToken(String authorizationCode, HttpServletRequest request) {

        String redirectURI = getRedirectURI(request.getHeader("Host"));

        NaverTokenBody tokenRs = getToken(authorizationCode, redirectURI);
        if(tokenRs.getError() != null) {
            throw new CustomException(tokenRs.getError()+ ": " + tokenRs.getError_description());
        }

        NaverUserInfoBody userInfo = getInfo(tokenRs.getAccessToken());

        String id = LoginType.NAVER.getIdPre() + userInfo.getId();
        if (userRepository.findById(id).isEmpty()) {
            // null일 경우 있으르 수 이씀
            userRepository.save(UserEntity.from(id, userInfo.getName(), userInfo.getEmail(), userInfo.getProfileUrl(), LoginType.NAVER));
        }

        String accessToken = jwtUtil.generateAccessToken(id, userInfo.getEmail());
        String refreshToken = jwtUtil.generateRefreshToken(id);

        return TokenRs.of(accessToken, refreshToken);

    }

    private NaverTokenBody getToken(String code, String redirectUri) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> bodyParams = new LinkedMultiValueMap<>();
        bodyParams.set("grant_type", "authorization_code");
        bodyParams.set("client_id", clientId);
        bodyParams.set("client_secret", clientSecret);
        bodyParams.set("redirect_uri", redirectUri);
        bodyParams.set("code", code);
        bodyParams.set("state", state);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(bodyParams, headers);

        ResponseEntity<NaverTokenBody> response = restTemplate.postForEntity(NAVER_TOKEN_URL, requestEntity, NaverTokenBody.class);

        return response.getBody();
    }

    private String getRedirectURI(String host) {
        if (host.contains("localhost:5173")) {
            // 로컬 환경
            return "http://localhost:5173/login/naver";
        } else if (host.contains("localhost:8080")) {
            return  "http://localhost:8080/login/oauth2/code/naver";
        } else if(host.contains("mh-mh.vercel.app")){
            // 프로덕션 환경
            return  "https://mh-mh.vercel.app/login/naver";
        }  else {
            throw new CustomException("허용된 host가 아닙니다.");
        }
    }

    private NaverUserInfoBody getInfo(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NaverUserInfoBody> userResult = restTemplate.exchange(
                NAVER_USER_INFO_URL,
                HttpMethod.GET,
                kakaoProfileRequest,
                NaverUserInfoBody.class
        );

        return userResult.getBody();
    }
}

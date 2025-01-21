package com.mondol.mhmh.auth.oAuth;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mondol.mhmh.auth.jwt.TokenRs;
import com.mondol.mhmh.auth.oAuth.kakao.KakaoTokenBody;
import com.mondol.mhmh.auth.oAuth.kakao.KakaoTokenPayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class KaKaoOAuthService {

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String redirectUri;

    private String kakaoTokenUri = "https://kauth.kakao.com/oauth/token";
    private String kakaoUserInfo ="https://kapi.kakao.com/v2/user/me"; // 사용자 정보 가져오기

    public TokenRs getAccessToken(String authorizationCode) {
        System.out.print("hereeee");
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> bodyParams = new LinkedMultiValueMap<>();
        bodyParams.set("grant_type", "authorization_code");
        bodyParams.set("client_id", clientId);
        bodyParams.set("redirect_uri", "http://localhost:8080/login/oauth2/code/kakao");
        bodyParams.set("code", authorizationCode); // add로 하면 []에 감싸져서 들어감
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(bodyParams, headers);


        // kakao 토큰 값
        ResponseEntity<KakaoTokenBody> response = restTemplate.postForEntity(kakaoTokenUri, requestEntity, KakaoTokenBody.class);


        System.out.print(response.getBody().getIdToken());
        response.getBody().getAccessToken();

        getInfo(response.getBody().getAccessToken());
        // payload로 유저 생성

        // payload의 nickname, email, user id 넣어서, kakao sub 넣어서 토큰 생성

        return TokenRs.of("","");
    }

    private String getInfo(String token) {
        HttpHeaders headers = new HttpHeaders();
        // Content-type을 application/x-www-form-urlencoded 로 설정
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String access_token = token;
        String userInfoURL = "https://kapi.kakao.com/v2/user/me";
// Header에 access_token 삽입
        headers.set("Authorization", "Bearer "+access_token);

// Request entity 생성
        HttpEntity<?> userInfoEntity = new HttpEntity<>(headers);

// Post 방식으로 Http 요청
// 응답 데이터 형식은 Hashmap 으로 지정
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HashMap> userResult = restTemplate.postForEntity(userInfoURL, userInfoEntity, HashMap.class);
        Map<String, String> userResultMap = userResult.getBody();
        System.out.println(userResultMap+ "맵입니다");
        return "";
    }

    private KakaoTokenPayload decodePayload(String jwtToken) throws Exception {
        System.out.println(jwtToken + "asdfasd token입니당");
        // 1. JWT 토큰을 '.' 기준으로 분리
//        String[] parts = jwtToken.split("\\.");
//        if (parts.length != 3) {
//            throw new IllegalArgumentException("Invalid JWT token format.");
//        }
//
//        // 2. payload 부분(Base64로 인코딩된 부분) 추출
//        String payload = parts[1]; // 그냥 token 자체가 페이로드인가?

        // 3. Base64 디코딩
//        String decodedPayload = new String(Base64.getDecoder().decode(jwtToken));

        // 4. JSON을 KakaoTokenPayload 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jwtToken, KakaoTokenPayload.class);
    }

    public Map<String, Object> getUserInfo(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(kakaoTokenUri, HttpMethod.GET, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch user information");
        }
    }
}

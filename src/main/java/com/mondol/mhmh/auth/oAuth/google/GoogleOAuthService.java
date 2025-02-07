package com.mondol.mhmh.auth.oAuth.google;

import com.fasterxml.jackson.databind.JsonNode;
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
public class GoogleOAuthService {
    @Value("${spring.security.oauth2.client.provider.google.token-uri}")
    private String GOOGLE_TOKEN_URL;

    @Value("${spring.security.oauth2.client.provider.google.user-info-uri}")
    private String GOOGLE_USER_INFO_URL;

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String clientSecret;

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    private final RestTemplate restTemplate = new RestTemplate();

    public TokenRs getAccessToken(String authorizationCode, HttpServletRequest request) {

        String host = request.getHeader("Origin") != null ? request.getHeader("Origin") : request.getHeader("Host");
        String redirectURI = getRedirectURI(host);

        String token = getToken(authorizationCode, redirectURI);
        if(token == null) {
            throw new CustomException(token +" " + authorizationCode + " " + redirectURI);
        }
        JsonNode userResourceNode = getUserResource(token);

        String id = LoginType.GOOGLE.getIdPre() + userResourceNode.get("id").asText();
        String email = userResourceNode.get("email").asText();
        String nickname = userResourceNode.get("name").asText();
        String profile = userResourceNode.get("picture").asText();

        if (userRepository.findById(id).isEmpty()) {
            userRepository.save(UserEntity.from(id, nickname, email, profile, LoginType.GOOGLE));
        }

        String accessToken = jwtUtil.generateAccessToken(id, email);
        String refreshToken = jwtUtil.generateRefreshToken(id);

        return TokenRs.of(accessToken, refreshToken);

    }

    private String getRedirectURI(String host) {

        if (host.contains("localhost:5173")) {
            // 로컬 환경
            return "http://localhost:5173/login/google";
        } else if (host.contains("localhost:8080")) {
            return  "http://localhost:8080/login/oauth2/code/google";
        } else if(host.contains("mh-mh.vercel.app")){
            // 프로덕션 환경
            return  "https://mh-mh.vercel.app/login/google";
        }  else if (host.contains("mhmh-backend.fly.dev")) {
            return "https://mhmh-backend.fly.dev/login/oauth2/code/google";
        } else {
            throw new CustomException("허용된 host가 아닙니다.");
        }
    }

    private String getToken(String code, String redirectUri) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity entity = new HttpEntity(params, headers);

        ResponseEntity<JsonNode> responseNode = restTemplate.exchange(GOOGLE_TOKEN_URL, HttpMethod.POST, entity, JsonNode.class);
        JsonNode accessTokenNode = responseNode.getBody();
        return accessTokenNode.get("access_token").asText();
    }

    private JsonNode getUserResource(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity entity = new HttpEntity(headers);
        return restTemplate.exchange(GOOGLE_USER_INFO_URL, HttpMethod.GET, entity, JsonNode.class).getBody();
    }


}

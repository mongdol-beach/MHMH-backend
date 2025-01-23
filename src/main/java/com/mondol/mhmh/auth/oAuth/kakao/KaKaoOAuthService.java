package com.mondol.mhmh.auth.oAuth.kakao;


import com.mondol.mhmh.auth.jwt.JwtUtil;
import com.mondol.mhmh.auth.jwt.TokenRs;
import com.mondol.mhmh.auth.oAuth.LoginType;
import com.mondol.mhmh.user.repository.UserRepository;
import com.mondol.mhmh.user.schema.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class KaKaoOAuthService {

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String redirectUri;

    private final String KAKAO_TOKEN_URL = "https://kauth.kakao.com/oauth/token";
    private final String KAKAO_USER_INFO_URL ="https://kapi.kakao.com/v2/user/me"; // 사용자 정보 가져오기

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public TokenRs getAccessToken(String authorizationCode) {
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
        ResponseEntity<KakaoTokenBody> response = restTemplate.postForEntity(KAKAO_TOKEN_URL, requestEntity, KakaoTokenBody.class);

        KakaoUserInfoBody userInfo = getInfo(response.getBody().getAccessToken());

        String id = LoginType.KAKAO.getIdPre()+userInfo.getId();
        if(userRepository.findById(id).isEmpty()) {
            userRepository.save(UserEntity.from(id,userInfo.getName(), userInfo.getEmail(), userInfo.getProfileUrl(), LoginType.KAKAO));
        }

        String accessToken = jwtUtil.generateAccessToken(id, userInfo.getEmail());
        String refreshToken = jwtUtil.generateRefreshToken(id);

        return TokenRs.of(accessToken, refreshToken);
    }

    private KakaoUserInfoBody getInfo(String token) {
        HttpHeaders headers = new HttpHeaders();
        // Content-type을 application/x-www-form-urlencoded 로 설정
        headers.setContentType(MediaType.valueOf("application/x-www-form-urlencoded;charset=utf-8"));

        headers.set("Authorization", "Bearer "+token);

        System.out.print(headers);
        HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest = new HttpEntity <>(headers);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<KakaoUserInfoBody> userResult = restTemplate.exchange(
                KAKAO_USER_INFO_URL,
                HttpMethod.GET,
                kakaoProfileRequest,
                KakaoUserInfoBody.class
        );

        System.out.println(userResult+ "맵입니다");
        return userResult.getBody();
    }

}

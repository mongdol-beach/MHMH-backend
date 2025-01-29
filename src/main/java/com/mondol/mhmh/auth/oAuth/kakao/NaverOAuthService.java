package com.mondol.mhmh.auth.oAuth.kakao;

import com.mondol.mhmh.auth.jwt.TokenRs;
import com.mondol.mhmh.exception.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
@Log4j2
public class NaverOAuthService {

    public TokenRs getAccessToken(String authorizationCode, HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String redirectURI = getRedirectURI(request.getHeader("Host"));
        return null;

    }

    private String getRedirectURI(String host) {
        if (host.contains("localhost:5173")) {
            // 로컬 환경
            return "http://localhost:5173/login/kakao";
        } else if (host.contains("localhost:8080")) {
            return  "http://localhost:8080/login/oauth2/code/kakao/test";
        } else if(host.contains("mh-mh.vercel.app")){
            // 프로덕션 환경
            return  "https://mh-mh.vercel.app/login/kakao";
        }  else {
            throw new CustomException("허용된 host가 아닙니다.");
        }
    }
}

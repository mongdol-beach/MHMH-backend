package com.mondol.mhmh.auth.oAuth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // 여기에 로그인 성공 후 처리할 내용을 작성하기!
        System.out.print("이곳은 blue");
        System.out.print(authentication);
        System.out.println(authentication.getPrincipal());
        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
        System.out.println(oAuth2User);
        System.out.println(oAuth2User.getAttributes());
//        request.get
        if (isUser(oAuth2User)) {
            response.sendRedirect("/login/oauth2/code/kakao");
        } else {
            response.sendRedirect("/login/oauth2/code/kakao");
        }
    }

    private boolean isUser(DefaultOAuth2User oAuth2User) {
        return oAuth2User.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_USER"));
    }
}
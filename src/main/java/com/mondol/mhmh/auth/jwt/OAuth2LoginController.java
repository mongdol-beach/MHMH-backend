package com.mondol.mhmh.auth.jwt;

import com.mondol.mhmh.auth.oAuth.CustomOAuth2UserService;
import com.mondol.mhmh.auth.oAuth.KaKaoOAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController()
public class OAuth2LoginController {
    private final CustomOAuth2UserService service;
    private final KaKaoOAuthService kakaoService;

    @GetMapping("/login/oauth2/code/kakao")
    public TokenRs kakaoLogin(@RequestParam String code) {
        return kakaoService.getAccessToken(code);
    }
}

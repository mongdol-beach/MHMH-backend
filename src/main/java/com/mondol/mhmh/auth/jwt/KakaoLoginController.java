package com.mondol.mhmh.auth.jwt;

import com.mondol.mhmh.auth.oAuth.CustomOAuth2UserService;
import com.mondol.mhmh.auth.oAuth.KaKaoOAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController()
public class KakaoLoginController {
    private final CustomOAuth2UserService service;
    private final KaKaoOAuthService kakaoService;
    @GetMapping("/login/oauth2/code/kakao")
    public String kakaoLogin(@RequestParam String code) {
        kakaoService.getAccessToken(code);
        System.out.println("여기오지않아여.." + code);
        return service.a(code);
//        String accessToken = kakaoApi.getAccessToken(code);
//        String accessToken = kakaoApi.getAccessToken(code);
    }
}

package com.mondol.mhmh.auth.jwt;

import com.mondol.mhmh.auth.oAuth.kakao.KaKaoOAuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController()
@Tag(name = "OAuth API", description = "OAuth2 리다이렉트 API입니다")
public class OAuth2LoginController {
    private final KaKaoOAuthService kakaoService;

    @GetMapping("/login/oauth2/code/kakao")
    public TokenRs kakaoLogin(@RequestParam String code) {
        return kakaoService.getAccessToken(code);
    }
}

package com.mondol.mhmh.auth.jwt;

import com.mondol.mhmh.auth.oAuth.kakao.KaKaoOAuthService;
import com.mondol.mhmh.auth.oAuth.naver.NaverOAuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController()
@Tag(name = "OAuth API", description = "OAuth2 API입니다")
public class OAuth2LoginController {
    private final KaKaoOAuthService kakaoService;
    private final NaverOAuthService naverService;

    // 카카오
    @GetMapping("/login/oauth2/code/kakao")
    public ResponseEntity<TokenRs> kakaoLogin(@RequestParam String code, HttpServletRequest request) {
        return kakaoService.getAccessToken(code, request);
    }

    @GetMapping("/login/oauth2/code/kakao/test")
    public String kakaoLoginTest(@RequestParam String code) {
        return code;
    }

    // 네이버
    @GetMapping("/login/oauth2/code/naver")
    public TokenRs naverLogin(@RequestParam String code, HttpServletRequest request) {
        return naverService.getAccessToken(code, request);
    }

}

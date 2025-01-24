package com.mondol.mhmh.auth.jwt;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/auth")
@Tag(name = "토큰 API", description = "토큰과 관련된 API 리스트입니다.")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/refresh")
    public TokenRs tokenRefresh(@RequestHeader("Refresh-Token") String refreshToken) {
        return authService.refreshToken(refreshToken);
    }
}

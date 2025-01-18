package com.mondol.mhmh.auth.jwt;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "토큰 발급 API 명세", description = "토큰과 관련된 API 리스트입니다.")
public class JwtController {

    // kakao login
    @PostMapping("/kakao")
    public TokenRs kakaoAuth(@RequestParam("code") String authorizationCode) {

        System.out.println(authorizationCode);
        // 서버는 Authorization Code로 Access Token을 교환.
        //Access Token으로 사용자 정보 API를 호출하여 사용자를 확인.
        // 사용자 정보는 DB에 저장하며, id와 같은 고유 식별자를 기준으로 조회 및 생성.
        return TokenRs.of("","");
    }


}

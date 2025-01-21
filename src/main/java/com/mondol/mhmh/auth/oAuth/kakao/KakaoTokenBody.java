package com.mondol.mhmh.auth.oAuth.kakao;

import lombok.AllArgsConstructor;
import lombok.Getter;

// https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api
@Getter
@AllArgsConstructor
public class KakaoTokenBody {
    private String token_type;
    private String access_token;
    private String id_token;
    private Integer expires_in;
    private String refresh_token;
    private Integer refresh_token_expires_in;
    private String scope;
}

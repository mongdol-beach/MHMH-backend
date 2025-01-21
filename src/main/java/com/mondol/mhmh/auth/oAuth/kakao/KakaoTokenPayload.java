package com.mondol.mhmh.auth.oAuth.kakao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KakaoTokenPayload {
    private String iss;
    private String aud;
    private String sub;
    private Integer iat;
    private Integer exp;
    private Integer auth_time;
    private String nonce;
    private String nickname;
    private String email;
    private String picture;
}

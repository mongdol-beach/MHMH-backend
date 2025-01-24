package com.mondol.mhmh.auth.oAuth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginType {
    KAKAO("K_"),
    NAVER("N_");
    private final String idPre;
}

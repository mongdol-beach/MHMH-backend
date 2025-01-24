package com.mondol.mhmh.auth.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
public class TokenRs {
    public String accessToken;
    public String refreshToken;
}

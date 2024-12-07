package com.mondol.mhmh.balanceGame.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BalanceQuestion {
    private final int id;
    private final String optionA;
    private final String optionB;
}

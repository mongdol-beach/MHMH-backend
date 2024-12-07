package com.mondol.mhmh.balanceGame.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class BalanceAnswerRs {
    private final int optionA;
    private final int optionB;
}

package com.mondol.mhmh.balanceGame.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BalanceAnswerRq {
    private final BalanceAnswerOption selectedOption;

    public enum BalanceAnswerOption {
        A, B
    }
}

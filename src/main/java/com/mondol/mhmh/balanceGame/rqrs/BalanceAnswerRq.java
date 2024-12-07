package com.mondol.mhmh.balanceGame.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BalanceAnswerRq {
    private final int id;
    private final BalanceAnswerOption option;

    public enum BalanceAnswerOption {
        A, B
    }
}

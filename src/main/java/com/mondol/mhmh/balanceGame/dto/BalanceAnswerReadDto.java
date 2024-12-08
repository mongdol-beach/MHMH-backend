package com.mondol.mhmh.balanceGame.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class BalanceAnswerReadDto {
    private final int optionAPercentage;
    private final int optionBPercentage;
}

package com.mondol.mhmh.balanceGame.rqrs;

import java.util.List;

import com.mondol.mhmh.balanceGame.dto.BalanceQuestionReadDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class BalanceQuestionListRs {
    private final List<BalanceQuestionReadDto> questions;
}

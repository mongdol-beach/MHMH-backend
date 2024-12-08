package com.mondol.mhmh.balanceGame.dto;

import com.mondol.mhmh.balanceGame.schema.BalanceQuestionEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BalanceQuestionReadDto {
  private final int id;
  private final String description;
  private final String optionA;
  private final String optionB;

  public static BalanceQuestionReadDto from(BalanceQuestionEntity entity) {
      return new BalanceQuestionReadDto(entity.getId(), entity.getDescription(), entity.getOptionA(), entity.getOptionB());
  }
}

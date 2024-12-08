package com.mondol.mhmh.balanceGame.schema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "balance_game_question")
@Getter
public class BalanceQuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    @Column(name = "option_a")
    private String optionA;

    @Column(name = "option_b")
    private String optionB;
}

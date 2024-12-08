package com.mondol.mhmh.balanceGame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mondol.mhmh.balanceGame.schema.BalanceQuestionEntity;

public interface BalanceQuestionRepository extends JpaRepository<BalanceQuestionEntity, Integer> {

}

package com.mondol.mhmh.balanceGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mondol.mhmh.balanceGame.schema.BalanceAnswerEntity;

public interface BalanceAnswerRepository extends JpaRepository<BalanceAnswerEntity, Integer> {
    List<BalanceAnswerEntity> findAllByQuestionId(int questionId);
}

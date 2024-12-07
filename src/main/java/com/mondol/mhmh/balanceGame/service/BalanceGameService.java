package com.mondol.mhmh.balanceGame.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mondol.mhmh.balanceGame.dto.BalanceQuestionReadDto;
import com.mondol.mhmh.balanceGame.repository.BalanceQuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BalanceGameService {

    private final BalanceQuestionRepository balanceQuestionRepository;

    public List<BalanceQuestionReadDto> readFiveRandomBalanceQuestionList() {
        List<BalanceQuestionReadDto> allQuestions = readAllBalanceQuestion();
        // REVIEW: 만약 질문이 5개 미만이라면 예외를 발생시켜야 할까?
        Collections.shuffle(allQuestions);
        return allQuestions.subList(0, 5);
    }

    public List<BalanceQuestionReadDto> readAllBalanceQuestion() {
        return this.balanceQuestionRepository.findAll().stream()
                .map(BalanceQuestionReadDto::from)
                .toList();
    }

}

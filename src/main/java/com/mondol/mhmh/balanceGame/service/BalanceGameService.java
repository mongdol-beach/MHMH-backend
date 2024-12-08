package com.mondol.mhmh.balanceGame.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mondol.mhmh.balanceGame.dto.BalanceAnswerReadDto;
import com.mondol.mhmh.balanceGame.dto.BalanceQuestionReadDto;
import com.mondol.mhmh.balanceGame.repository.BalanceAnswerRepository;
import com.mondol.mhmh.balanceGame.repository.BalanceQuestionRepository;
import com.mondol.mhmh.balanceGame.rqrs.BalanceAnswerRq;
import com.mondol.mhmh.balanceGame.schema.BalanceAnswerEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BalanceGameService {

    private final BalanceQuestionRepository balanceQuestionRepository;
    private final BalanceAnswerRepository balanceAnswerRepository;

    public List<BalanceQuestionReadDto> readFiveRandomBalanceQuestionList() {
        List<BalanceQuestionReadDto> allQuestions = readAllBalanceQuestion();
        // REVIEW: 만약 질문이 5개 미만이라면 예외를 발생시켜야 할까?
        Collections.shuffle(allQuestions);
        int size = Math.min(allQuestions.size(), 5);
        return allQuestions.subList(0, size);
    }

    public List<BalanceQuestionReadDto> readAllBalanceQuestion() {
        return this.balanceQuestionRepository.findAll().stream()
                .map(BalanceQuestionReadDto::from)
                .toList();
    }

    public BalanceAnswerReadDto answerBalanceQuestion(int questionId, BalanceAnswerRq answer) {
        // 응답 저장
        BalanceAnswerEntity answerEntity = new BalanceAnswerEntity();
        answerEntity.setQuestionId(questionId);
        answerEntity.setSelectedOption(answer.getSelectedOption().name());
        balanceAnswerRepository.save(answerEntity);

        // 응답 통계 계산
        List<BalanceAnswerEntity> answers = balanceAnswerRepository.findAllByQuestionId(questionId);
        long totalCount = answers.size();
        long optionACount = answers.stream()
                .filter(a -> "A".equals(a.getSelectedOption()))
                .count();

        int optionAPercentage = (int) ((optionACount * 100.0) / totalCount);
        int optionBPercentage = 100 - optionAPercentage;

        return BalanceAnswerReadDto.of(optionAPercentage, optionBPercentage);
    }

}

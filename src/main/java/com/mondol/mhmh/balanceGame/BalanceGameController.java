package com.mondol.mhmh.balanceGame;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mondol.mhmh.balanceGame.dto.BalanceAnswerReadDto;
import com.mondol.mhmh.balanceGame.dto.BalanceQuestionReadDto;
import com.mondol.mhmh.balanceGame.rqrs.BalanceAnswerRq;
import com.mondol.mhmh.balanceGame.rqrs.BalanceAnswerRs;
import com.mondol.mhmh.balanceGame.rqrs.BalanceQuestionListRs;
import com.mondol.mhmh.balanceGame.service.BalanceGameService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "balance-game", description = "밸런스 게임 API")
@RestController
@RequestMapping("/balance-game")
@RequiredArgsConstructor
public class BalanceGameController {

    private final BalanceGameService gameService;

    @Operation(summary = "밸런스 게임 질문 조회 (5개)")
    @GetMapping("/questions")
    public BalanceQuestionListRs readBalanceQuestionList() {
        List<BalanceQuestionReadDto> questions = this.gameService.readFiveRandomBalanceQuestionList();
        return BalanceQuestionListRs.of(questions);
    }

    @Operation(summary = "밸런스 게임 질문 응답")
    @PostMapping("/questions/{id}/answer")
    public BalanceAnswerRs answerBalanceQuestion(@PathVariable int id, @RequestBody BalanceAnswerRq answer) {
        BalanceAnswerReadDto stat = gameService.answerBalanceQuestion(id, answer);
        return BalanceAnswerRs.of(stat.getOptionAPercentage(), stat.getOptionBPercentage());
    }
}

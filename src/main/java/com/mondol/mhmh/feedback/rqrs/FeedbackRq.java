package com.mondol.mhmh.feedback.rqrs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FeedbackRq {

    @NotNull(message = "피드백 유형은 필수입니다.")
    private FeedbackType type;

    @NotBlank(message = "메시지는 비워둘 수 없습니다.")
    @Size(max = 1000, message = "메시지는 1000자를 초과할 수 없습니다.")
    private String message;

    @Getter
    @AllArgsConstructor
    public enum FeedbackType {
        BAD("별로에요"),
        AVERAGE("그저 그래요"),
        EXCELLENT("최고에요");

        private final String description;
    }
}

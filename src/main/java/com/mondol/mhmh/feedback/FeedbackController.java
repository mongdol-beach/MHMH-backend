package com.mondol.mhmh.feedback;

import com.mondol.mhmh.feedback.rqrs.FeedbackRq;
import com.mondol.mhmh.feedback.service.FeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "feedbacks", description = "피드백 API")
@RequiredArgsConstructor
@RequestMapping("/feedbacks")
@RestController
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Operation(summary = "피드백 전송")
    @PostMapping()
    public ResponseEntity<Void> submitFeedback(@Valid @RequestBody FeedbackRq body) {
        this.feedbackService.saveFeedback(body);
        return ResponseEntity.noContent().build();
    }
}

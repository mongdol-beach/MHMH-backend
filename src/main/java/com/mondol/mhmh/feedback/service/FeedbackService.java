package com.mondol.mhmh.feedback.service;

import com.mondol.mhmh.feedback.repository.FeedbackRepository;
import com.mondol.mhmh.feedback.rqrs.FeedbackRq;
import com.mondol.mhmh.feedback.schema.FeedbackEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public void saveFeedback(FeedbackRq feedbackRq) {
        FeedbackEntity feedbackEntity = new FeedbackEntity();
        feedbackEntity.setType(feedbackRq.getType().name());
        feedbackEntity.setMessage(feedbackRq.getMessage());

        feedbackRepository.save(feedbackEntity);
    }
}

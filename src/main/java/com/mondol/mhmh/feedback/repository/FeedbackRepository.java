package com.mondol.mhmh.feedback.repository;

import com.mondol.mhmh.feedback.schema.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Integer> {

}

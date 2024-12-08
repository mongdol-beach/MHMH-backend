package com.mondol.mhmh.topic.repository;

import com.mondol.mhmh.topic.schema.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicEntity, Integer> {

}

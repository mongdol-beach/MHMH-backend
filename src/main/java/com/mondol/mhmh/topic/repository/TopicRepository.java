package com.mondol.mhmh.topic.repository;

import com.mondol.mhmh.topic.schema.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends JpaRepository<TopicEntity, Integer> {
    @Query(value = "SELECT * FROM topic TABLESAMPLE BERNOULLI(100) LIMIT :limit", nativeQuery = true)
    List<TopicEntity> findTopicByLimit(@Param("limit") int limit);

    @Query(value = "SELECT * FROM topic TABLESAMPLE BERNOULLI(100) WHERE situation_type=:situation LIMIT :limit", nativeQuery = true)
    List<TopicEntity> findTopicByLimitAndSituation(@Param("limit") int limit, @Param("situation") String situation);

    List<TopicEntity> findAllBySituationType(String type);
}

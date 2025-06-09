package com.mondol.mhmh.topic.repository;

import com.mondol.mhmh.topic.schema.TopicEntity;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicRepository extends JpaRepository<TopicEntity, Integer> {
    @Query(value = "SELECT * FROM topic TABLESAMPLE BERNOULLI(10) LIMIT :limit", nativeQuery = true)
    List<TopicEntity> findTopicByLimit(@Param("limit") int limit);

    @Query(value = "SELECT * FROM topic TABLESAMPLE BERNOULLI(45) WHERE situation_type=:situation LIMIT :limit", nativeQuery = true)
    List<TopicEntity> findTopicByLimitAndSituation(@Param("limit") int limit, @Param("situation") String situation);

    @Query(value = """
    SELECT * FROM topic ORDER BY MOD(ABS(CAST(hashtext(CAST(topic_id AS TEXT) || CAST(:seed AS TEXT)) AS BIGINT)), 1000000)
    """,
            countQuery = "SELECT COUNT(*) FROM topic",
            nativeQuery = true)
    Page<TopicEntity> findAllRandomWithSeed(@Param("seed") int seed, Pageable pageable);



    @Query(value = "SELECT setseed(:seed)", nativeQuery = true)
    void setSeed(@Param("seed") double seed);

    @Query(value = "SELECT * FROM topic ORDER BY random()",
            countQuery = "SELECT COUNT(*) FROM topic",
            nativeQuery = true)
    Page<TopicEntity> findAllRandom(Pageable pageable);

    List<TopicEntity> findAllBySituationType(String type);

    List<TopicEntity> findAllByPersonSituation_Type(String type);
}

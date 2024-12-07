package com.mondol.mhmh.situation.repository;

import com.mondol.mhmh.situation.schema.SituationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituationRepository extends JpaRepository<SituationEntity, String> {
}

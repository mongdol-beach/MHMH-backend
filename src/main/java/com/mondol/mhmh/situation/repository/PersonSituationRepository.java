package com.mondol.mhmh.situation.repository;

import com.mondol.mhmh.situation.schema.PersonSituationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSituationRepository extends JpaRepository<PersonSituationEntity, String> {
}

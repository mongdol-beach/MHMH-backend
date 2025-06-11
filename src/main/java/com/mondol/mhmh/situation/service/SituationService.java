package com.mondol.mhmh.situation.service;

import com.mondol.mhmh.situation.dto.SituationReadDto;
import com.mondol.mhmh.situation.repository.PersonSituationRepository;
import com.mondol.mhmh.situation.repository.SituationRepository;
import com.mondol.mhmh.situation.schema.PersonSituationEntity;
import com.mondol.mhmh.situation.schema.SituationEntity;
import com.mondol.mhmh.situation.schema.SituationType;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SituationService {
    private final SituationRepository situationRepository;
    private final PersonSituationRepository personSituationRepository;

    public List<SituationReadDto> readSituationList() {
        List<SituationEntity> situations = situationRepository.findAll();
        List<String> types = SituationType.getList();
        List<SituationEntity> filteredS = situations.stream().filter(s -> types.contains(s.getType())).toList();

        return filteredS.stream().map(SituationReadDto::from).toList();
    }

    public List<SituationReadDto> readPersonSituationList() {
        List<PersonSituationEntity> situations = personSituationRepository.findAll();

        return situations.stream().map(SituationReadDto::from).toList();
    }
}

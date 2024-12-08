package com.mondol.mhmh.situation.service;

import com.mondol.mhmh.situation.dto.SituationReadDto;
import com.mondol.mhmh.situation.repository.SituationRepository;
import com.mondol.mhmh.situation.schema.SituationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SituationService {
    private final SituationRepository situationRepository;

    public List<SituationReadDto> readSituationList() {
        List<SituationEntity> situations = situationRepository.findAll();

        return situations.stream().map(SituationReadDto::from).toList();
    }
}

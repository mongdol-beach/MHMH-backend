package com.mondol.mhmh.situation.service;

import com.mondol.mhmh.situation.rqrs.SituationReadItemRs;
import com.mondol.mhmh.situation.rqrs.SituationReadListRs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SituationService {
    public SituationReadListRs readSituationList() {
        List<SituationReadItemRs> rs = new ArrayList<>();

        rs.add(new SituationReadItemRs("DATE", "소개팅", "FFFFFF", "000000"));

        rs.add(new SituationReadItemRs("TEST", "테스트 상황 2", "000000", "FFFFFF"));

        return SituationReadListRs.of(rs);
    }
}

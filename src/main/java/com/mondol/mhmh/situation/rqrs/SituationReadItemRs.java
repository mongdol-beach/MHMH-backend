package com.mondol.mhmh.situation.rqrs;

import com.mondol.mhmh.situation.dto.SituationReadDto;
import com.mondol.mhmh.topic.rqrs.SituationCardColor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SituationReadItemRs {
    private String id;
    private String title;
    private SituationCardColor cardColor;

    public static SituationReadItemRs from (SituationReadDto dto) {
        return new SituationReadItemRs(dto.getType(), dto.getTitle(), SituationCardColor.valueOf(dto.getType()));
    }
}

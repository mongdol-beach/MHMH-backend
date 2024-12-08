package com.mondol.mhmh.situation.rqrs;

import com.mondol.mhmh.situation.dto.SituationReadDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SituationReadItemRs {
    private String id;
    private String title;
    private String color;
    private String textColor;

    public static SituationReadItemRs from (SituationReadDto dto) {
        return new SituationReadItemRs(dto.getType(), dto.getTitle(), dto.getColor(), dto.getTextColor());
    }
}

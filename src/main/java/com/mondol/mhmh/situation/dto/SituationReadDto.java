package com.mondol.mhmh.situation.dto;

import com.mondol.mhmh.situation.schema.PersonSituationEntity;
import com.mondol.mhmh.situation.schema.SituationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor()
@Getter
public class SituationReadDto {
    private String type;
    private String title;
    private String color;
    private String textColor;

    public static SituationReadDto from(SituationEntity entity) {
        return new SituationReadDto(entity.getType(), entity.getTitle(), entity.getColor(), entity.getTextColor());
    }

    public static SituationReadDto from(PersonSituationEntity entity) {
        return new SituationReadDto(entity.getType(), entity.getTitle(), entity.getColor(), entity.getTextColor());
    }
}

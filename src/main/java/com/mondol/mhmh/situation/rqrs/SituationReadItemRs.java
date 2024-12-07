package com.mondol.mhmh.situation.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SituationReadItemRs {
    private String id;
    private String title;
    private String color;
    private String textColor;
}

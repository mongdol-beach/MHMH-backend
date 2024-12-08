package com.mondol.mhmh.situation.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SituationType {
    DATE("소개팅"),
    COMPANY("회사"),
    COFFEE("커피챗"),
    SMALL("스몰토크"),
    TOGETHER("단체 모임"),
    COUPLE("커플");
    private final String name;
}

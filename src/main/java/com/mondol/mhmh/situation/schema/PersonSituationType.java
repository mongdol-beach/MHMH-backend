package com.mondol.mhmh.situation.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PersonSituationType {
    COLLEAGUE("직장 동료"),
    SENIORITY("선후배"),
    CLUB("동호회"),
    OLD_FRIEND("오랜만에 만난 친구"),
    FAMILY("가족"),
    FIRST_FRIEND("처음 만난 사람");
    private final String name;
}
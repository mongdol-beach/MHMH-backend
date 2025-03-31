package com.mondol.mhmh.situation.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PersonSituationType {
    COLLEAGUE("직장 동료");
    private final String name;
}
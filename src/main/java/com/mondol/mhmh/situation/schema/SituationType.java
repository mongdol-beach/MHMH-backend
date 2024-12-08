package com.mondol.mhmh.situation.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SituationType {
    DATE("소개팅");
    private final String name;
}

package com.mondol.mhmh.situation.schema;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    public static List<String> getList() {
        return Arrays.stream(SituationType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}

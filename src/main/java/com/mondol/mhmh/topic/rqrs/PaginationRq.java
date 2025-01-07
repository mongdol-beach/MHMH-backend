package com.mondol.mhmh.topic.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PaginationRq {
    private int page;
    private int size;
}

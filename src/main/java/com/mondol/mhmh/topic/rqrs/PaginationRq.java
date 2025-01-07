package com.mondol.mhmh.topic.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PaginationRq {
    private int page;
    private int size;
}

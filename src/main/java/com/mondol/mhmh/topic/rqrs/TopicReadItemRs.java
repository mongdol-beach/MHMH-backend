package com.mondol.mhmh.topic.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TopicReadItemRs{
    private int id;
    private String content;
    private boolean isRecommend;
}

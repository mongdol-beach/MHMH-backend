package com.mondol.mhmh.topic.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TopicReadItemRs{
    private int id;
    private String content;
    private Boolean isRecommend;
    private List<TopicTipRs> tips;
}

package com.mondol.mhmh.topic.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AllTopicReadItemRs {
    private int id;
    private String content;
    private List<TopicTipRs> tips;
}

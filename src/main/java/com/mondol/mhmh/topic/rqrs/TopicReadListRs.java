package com.mondol.mhmh.topic.rqrs;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(staticName = "of")
public class TopicReadListRs {
    private List<TopicReadItemRs> lists;
}

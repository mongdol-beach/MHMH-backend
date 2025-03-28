package com.mondol.mhmh.topic.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class TopicReadListRs {
    private List<TopicReadItemRs> topics;
    private int page;
    private int size;
    private int totalCount;
    private int totalPage;
}

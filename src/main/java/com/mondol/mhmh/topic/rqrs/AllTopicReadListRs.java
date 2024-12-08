package com.mondol.mhmh.topic.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class AllTopicReadListRs {
    private String situationId;
    private String situationName;
    private List<AllTopicReadItemRs> topics;
}

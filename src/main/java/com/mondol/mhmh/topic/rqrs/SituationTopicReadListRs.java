package com.mondol.mhmh.topic.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class SituationTopicReadListRs {
    private String situationType;
    private String situationName;
    private List<SituationTopicReadItemRs> topics;
}

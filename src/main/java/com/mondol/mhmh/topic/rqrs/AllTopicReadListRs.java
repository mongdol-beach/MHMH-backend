package com.mondol.mhmh.topic.rqrs;

import com.mondol.mhmh.situation.schema.SituationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class AllTopicReadListRs {
    private SituationType situationId;
    private String situationName;
    private SituationCardColor situationColor;
    private List<AllTopicReadItemRs> topics;

    public static  AllTopicReadListRs of(SituationType situation, List<AllTopicReadItemRs> topic) {
        return new AllTopicReadListRs(situation, situation.getName(), SituationCardColor.valueOf(situation.toString()), topic);
    }
}

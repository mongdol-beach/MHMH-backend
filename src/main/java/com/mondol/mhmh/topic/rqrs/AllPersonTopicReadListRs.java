package com.mondol.mhmh.topic.rqrs;

import com.mondol.mhmh.situation.schema.PersonSituationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class AllPersonTopicReadListRs {
    private PersonSituationType situationId;
    private String situationName;
    private SituationCardColor situationColor;
    private List<AllTopicReadItemRs> topics;

    public static AllPersonTopicReadListRs of(PersonSituationType situation, List<AllTopicReadItemRs> topic) {
        return new AllPersonTopicReadListRs(situation, situation.getName(), SituationCardColor.valueOf(situation.toString()), topic);
    }
}

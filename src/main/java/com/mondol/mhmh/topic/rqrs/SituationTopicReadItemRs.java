package com.mondol.mhmh.topic.rqrs;

import com.mondol.mhmh.topic.dto.TopicReadDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SituationTopicReadItemRs {
    private int id;
    private String content;
    private List<TopicTipRs> tips;

    public static SituationTopicReadItemRs from(TopicReadDto dto) {
        return new SituationTopicReadItemRs(
                dto.getId(), dto.getContent(), dto.getTopicTip().stream().map(TopicTipRs::from).toList()
        );
    }
}

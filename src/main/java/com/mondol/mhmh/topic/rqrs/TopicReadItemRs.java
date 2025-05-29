package com.mondol.mhmh.topic.rqrs;

import com.mondol.mhmh.topic.dto.RandomTopicReadDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TopicReadItemRs {
    private int id;
    private String content;
    private List<TopicTipRs> tips;
    private String situationType;
    private String situationName;
    private SituationCardColor situationColor;

    public static TopicReadItemRs from(RandomTopicReadDto dto) {
        return new TopicReadItemRs(
                dto.getId(), dto.getContent(), dto.getTopicTip().stream().map(TopicTipRs::from).toList(), dto.getSituationId().toString(), dto.getSituationName(), SituationCardColor.valueOf(dto.getSituationId().toString())
        );
    }
}

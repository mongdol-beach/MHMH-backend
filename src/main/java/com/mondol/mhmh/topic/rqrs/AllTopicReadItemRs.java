package com.mondol.mhmh.topic.rqrs;

import com.mondol.mhmh.topic.dto.TopicReadDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AllTopicReadItemRs {
    private int id;
    private String content;
    private List<TopicTipRs> tips;

    public static AllTopicReadItemRs from(TopicReadDto dto) {
        return new AllTopicReadItemRs(
                dto.getId(), dto.getContent(), dto.getTopicTip().stream().map(TopicTipRs::from).toList()
        );
    }
}

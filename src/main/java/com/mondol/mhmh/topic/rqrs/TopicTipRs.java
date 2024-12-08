package com.mondol.mhmh.topic.rqrs;

import com.mondol.mhmh.topic.dto.TopicTipDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TopicTipRs {
    private String title;
    private List<String> content;

    public static TopicTipRs from(TopicTipDto dto) {
        return new TopicTipRs(dto.getTitle(), dto.getContent());
    }
}

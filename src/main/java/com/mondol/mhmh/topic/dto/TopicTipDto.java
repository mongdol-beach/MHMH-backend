package com.mondol.mhmh.topic.dto;

import com.mondol.mhmh.topic.schema.TopicTipEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class TopicTipDto {
    private String title;
    private List<String> content;

    public static TopicTipDto from(TopicTipEntity entity) {
        return new TopicTipDto(entity.getTitle(), entity.getContents());
    }
}

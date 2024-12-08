package com.mondol.mhmh.topic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor()
@Getter
public class RandomTopicReadDto {
    private int id;
    private String content;
    private String situationId;
    private String situationName;
    private List<TopicTipDto> topicTip;
}

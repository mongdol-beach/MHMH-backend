package com.mondol.mhmh.topic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor()
@Getter
public class TopicReadDto {
    private int id;
    private String content;
    private List<TopicTipDto> topicTip;
}

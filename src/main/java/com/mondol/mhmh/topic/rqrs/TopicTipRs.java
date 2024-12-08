package com.mondol.mhmh.topic.rqrs;

import com.mondol.mhmh.topic.dto.TopicTipDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class TopicTipRs {
    private String title;
    private List<String> content;

    public static TopicTipRs from(TopicTipDto dto) {
        return new TopicTipRs(dto.getTitle(), dto.getContent());
    }

    public static List<TopicTipRs> commonTopicRsList() {
        List<TopicTipRs> topicTipRsList = new ArrayList<>();
        List<String> s = new ArrayList<>();
        s.add("content1");
        s.add("content2");
        topicTipRsList.add(new TopicTipRs("소제목 1입니다.",s));
        topicTipRsList.add(new TopicTipRs("소제목 2입니다.",s));
        return topicTipRsList;
    }
}

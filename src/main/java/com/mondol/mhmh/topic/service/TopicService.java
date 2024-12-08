package com.mondol.mhmh.topic.service;

import com.mondol.mhmh.topic.rqrs.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    public TopicReadListRs readTopicList(int count) {
        List<TopicReadItemRs> list = new ArrayList<>();
        List<TopicTipRs> rs = new ArrayList<>();
        rs.add(new TopicTipRs("소제목 1", Arrays.asList("설명1", "설명2", "설명3")));
        rs.add(new TopicTipRs("소제목 2", Arrays.asList("설명1", "설명2")));
        list.add(new TopicReadItemRs(1, "기분 어때요?", rs));
        list.add(new TopicReadItemRs(23, "날씨 어때요?", rs));
        list.add(new TopicReadItemRs(231, "책 어때요?",  rs));
        list.add(new TopicReadItemRs(21, "공부 어때요?", rs));
        list.add(new TopicReadItemRs(2, "인사해보세요", rs));
        return TopicReadListRs.of(list);
    }

    public AllTopicReadListRs readALlTopic(int count) {
        List<AllTopicReadItemRs> list = new ArrayList<>();
        List<TopicTipRs> rs = new ArrayList<>();
        rs.add(new TopicTipRs("소제목 1", Arrays.asList("설명1", "설명2", "설명3")));
        rs.add(new TopicTipRs("소제목 2", Arrays.asList("설명1", "설명2")));
        list.add(new AllTopicReadItemRs(1, "기분 어때요?", rs));
        list.add(new AllTopicReadItemRs(23, "날씨 어때요?",  rs));
        list.add(new AllTopicReadItemRs(231, "책 어때요?",  rs));
        list.add(new AllTopicReadItemRs(21, "공부 어때요?", rs));
        list.add(new AllTopicReadItemRs(2, "인사해보세요",  rs));
        return AllTopicReadListRs.of("DATE","소개팅", list);
    }
}

package com.mondol.mhmh.topic.service;

import com.mondol.mhmh.topic.rqrs.TopicReadItemRs;
import com.mondol.mhmh.topic.rqrs.TopicReadListRs;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    public TopicReadListRs readTopicList(int count) {
        List<TopicReadItemRs> list = new ArrayList<>();
        list.add(new TopicReadItemRs(1, "기분 어때요?", false));
        list.add(new TopicReadItemRs(23, "날씨 어때요?", false));
        list.add(new TopicReadItemRs(231, "책 어때요?", false));
        list.add(new TopicReadItemRs(21, "공부 어때요?", false));
        list.add(new TopicReadItemRs(2, "인사해보세요", false));
        return TopicReadListRs.of(list);
    }
}

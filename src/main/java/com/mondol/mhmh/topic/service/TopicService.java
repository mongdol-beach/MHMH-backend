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
        list.add(new TopicReadItemRs(1, "기분 어때요?", false, "tip입니다."));
        list.add(new TopicReadItemRs(23, "날씨 어때요?", false, "1. 이렇게 하기 \n - 이렇게요 \n 2. 이렇게 하면 됩니다"));
        list.add(new TopicReadItemRs(231, "책 어때요?", false, "tip"));
        list.add(new TopicReadItemRs(21, "공부 어때요?", false, "tip"));
        list.add(new TopicReadItemRs(2, "인사해보세요", false, "tip"));
        return TopicReadListRs.of(list);
    }
}

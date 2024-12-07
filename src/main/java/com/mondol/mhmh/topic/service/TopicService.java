package com.mondol.mhmh.topic.service;

import com.mondol.mhmh.topic.rqrs.TopicReadItemRs;
import com.mondol.mhmh.topic.rqrs.TopicReadListRs;
import com.mondol.mhmh.topic.rqrs.TopicTipRs;
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
        list.add(new TopicReadItemRs(1, "기분 어때요?", false, rs));
        list.add(new TopicReadItemRs(23, "날씨 어때요?", false, rs));
        list.add(new TopicReadItemRs(231, "책 어때요?", false, rs));
        list.add(new TopicReadItemRs(21, "공부 어때요?", false, rs));
        list.add(new TopicReadItemRs(2, "인사해보세요", false, rs));
        return TopicReadListRs.of(list);
    }
}

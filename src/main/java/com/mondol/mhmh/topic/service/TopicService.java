package com.mondol.mhmh.topic.service;

import com.mondol.mhmh.topic.dto.RandomTopicReadDto;
import com.mondol.mhmh.topic.dto.TopicReadDto;
import com.mondol.mhmh.topic.dto.TopicTipDto;
import com.mondol.mhmh.topic.repository.TopicRepository;
import com.mondol.mhmh.topic.schema.TopicEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public List<RandomTopicReadDto> readRandomTopicList(int count) {
        List<TopicEntity> topics = topicRepository.findTopicByLimit(count);
//        while(topics.size() != 5) {
//            topics = topicRepository.findTopicByLimit(count);
//        }

        return topics.stream().map(topic -> new RandomTopicReadDto(
               topic.getId(), topic.getContent(),
               topic.getSituation().getType(), topic.getSituation().getTitle(),
               getCommonTips()
       )).toList();
    }

    public List<TopicReadDto> readRandomTopicBySituation(int count, String situation) {
        List<TopicEntity> topics = topicRepository.findTopicByLimitAndSituation(count, situation);
//        while(topics.size() != 5) {
//            topics = topicRepository.findTopicByLimitAndSituation(count,situation);
//        }

        return topics.stream().map(topic -> new TopicReadDto(
                topic.getId(), topic.getContent(),
                getCommonTips()
//                topic.getTips().stream().map(TopicTipDto::from).toList()
        )).toList();
    }

    public List<TopicReadDto> readALlTopicBySituation(String situation) {
        List<TopicEntity> topics = topicRepository.findAllBySituationType(situation);

        return topics.stream().map(topic -> new TopicReadDto(
                topic.getId(), topic.getContent(),
                getCommonTips()
        )).toList();
    }

    public List<TopicTipDto> getCommonTips() {
        return null;
    }
}

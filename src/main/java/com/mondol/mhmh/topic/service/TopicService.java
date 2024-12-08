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
        while(topics.size() != 5) {
            topics = topicRepository.findTopicByLimit(count);
        }

        return topics.stream().map(topic -> new RandomTopicReadDto(
               topic.getId(), topic.getContent(),
               topic.getSituation().getType(), topic.getSituation().getTitle(),
               topic.getTips().stream().map(TopicTipDto::from).toList()
       )).toList();
    }

    // 임시 코드
    public List<TopicReadDto> readRandomTopicBySituation(int count, String situation) {
        List<TopicEntity> topics = topicRepository.findAllBySituationType(situation).stream().limit(5).toList();

        return topics.stream().map(topic -> new TopicReadDto(
                topic.getId(), topic.getContent(),
                topic.getTips().stream().map(TopicTipDto::from).toList()
        )).toList();
    }

    public List<TopicReadDto> readALlTopicBySituation(String situation) {
        List<TopicEntity> topics = topicRepository.findAllBySituationType(situation);

        return topics.stream().map(topic -> new TopicReadDto(
                topic.getId(), topic.getContent(),
                topic.getTips().stream().map(TopicTipDto::from).toList()
        )).toList();
    }
}

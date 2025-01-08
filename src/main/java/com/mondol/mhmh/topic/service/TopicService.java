package com.mondol.mhmh.topic.service;

import com.mondol.mhmh.topic.dto.RandomTopicReadDto;
import com.mondol.mhmh.topic.dto.TopicReadDto;
import com.mondol.mhmh.topic.dto.TopicTipDto;
import com.mondol.mhmh.topic.repository.TopicRepository;
import com.mondol.mhmh.topic.schema.TopicEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public Page<RandomTopicReadDto> readRandomTopicList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TopicEntity> topics = topicRepository.findAll(pageable);

        List<RandomTopicReadDto> dtos = topics.getContent()
                .stream()
                .sorted((a, b) -> Double.compare(Math.random(), 0.5)) // 랜덤으로 섞기
                .map(this::convertToDto)
                .toList();

        return new PageImpl<>(dtos, pageable, topics.getTotalElements());
    }

    private RandomTopicReadDto convertToDto(TopicEntity topic) {
        return new RandomTopicReadDto(
                topic.getId(),
                topic.getContent(),
                topic.getSituation().getType(),
                topic.getSituation().getTitle(),
                getCommonTips()
        );
    }

    public List<TopicReadDto> readRandomTopicBySituation(int count, String situation) {
        List<TopicEntity> topics = topicRepository.findAllBySituationType(situation);

        Collections.shuffle(topics);

        return topics.subList(0, Math.min(topics.size(), count)).stream().map(topic -> new TopicReadDto(
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

    // 하나의 팁만 사용하게 되면서 db에 저장하지 않도록 바꾸었습니다.
    public List<TopicTipDto> getCommonTips() {
        List<TopicTipDto> dto = new ArrayList<>();
        dto.add(new TopicTipDto(
                "상대방의 답변을 공감하며 확장하기",
                Arrays.asList(
                        "반응하기: 상대의 답변에 긍정적인 리액션을 보여주세요.",
                        "관련된 경험 공유: \"비슷한 거 해봤는데 재미있더라구요.\" 라고 말하며 공통점을 찾아가세요."
                )
        ));

        dto.add(new TopicTipDto(
                "관심사를 탐색하며 구체적인 질문 던지기",
                Arrays.asList(
                        "\"운동하신다고 했는데, 주로 어떤 운동을 하세요?\"",
                        "\"최근 본 영화 중에 가장 재밌었던 건 뭐였어요?\""
                )
        ));

        return dto;
    }
}

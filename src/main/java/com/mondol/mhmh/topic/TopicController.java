package com.mondol.mhmh.topic;

import com.mondol.mhmh.situation.schema.SituationType;
import com.mondol.mhmh.topic.rqrs.*;
import com.mondol.mhmh.topic.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
@Tag(name = "토픽 API 명세", description = "토픽과 관련된 API 리스트입니다.")
public class TopicController {
    private final TopicService topicService;

    @Operation(summary = "랜덤 토픽 리스트를 조회해옵니다.")
    @GetMapping()
    public TopicReadListRs readRandomTopic() {
        return TopicReadListRs.of(
                topicService.readRandomTopicList(5).stream().map(TopicReadItemRs::from).toList()
        );
    }

    @Operation(summary = "상황별 토픽 리스트를 조회해옵니다. // 기능 구현 안됨")
    @GetMapping("/situation/{situation}")
    public SituationTopicReadListRs readTopicBySituation(@PathVariable String situation) {
        return SituationTopicReadListRs.of(
                topicService.readRandomTopicBySituation(5, situation).stream().map(SituationTopicReadItemRs::from).toList()
        );
    }

    @Operation(summary = "상황별 전체 토픽 리스트를 조회해옵니다.")
    @GetMapping("/situation/{situation}/all")
    public AllTopicReadListRs readAllTopicBySituation(@PathVariable String situation) {
        List<AllTopicReadItemRs> topic = topicService.readALlTopicBySituation(situation).stream().map(AllTopicReadItemRs::from).toList();
        return AllTopicReadListRs.of(SituationType.valueOf(situation), topic);
    }
}

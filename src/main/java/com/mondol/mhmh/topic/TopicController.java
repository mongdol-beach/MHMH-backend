package com.mondol.mhmh.topic;

import com.mondol.mhmh.topic.rqrs.AllTopicReadListRs;
import com.mondol.mhmh.topic.rqrs.TopicReadListRs;
import com.mondol.mhmh.topic.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
@Tag(name = "토픽 API 명세", description = "토픽과 관련된 API 리스트입니다.")
public class TopicController {
    private final TopicService topicService;

    @Operation(summary = "랜덤 토픽 리스트를 조회해옵니다.")
    @GetMapping()
    public TopicReadListRs readRandomTopic() {
        return topicService.readTopicList(5);
    }

    @Operation(summary = "상황별 토픽 리스트를 조회해옵니다.")
    @GetMapping("/situation/{situation}")
    public TopicReadListRs readTopicBySituation(@PathVariable String situation) {
        return topicService.readTopicList(5);
    }

    @Operation(summary = "상황별 전체 토픽 리스트를 조회해옵니다.")
    @GetMapping("/situation/{situation}/all")
    public AllTopicReadListRs readAllTopicBySituation(@PathVariable String situation) {
        return topicService.readALlTopic(5);
    }
}

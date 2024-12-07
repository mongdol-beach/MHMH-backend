package com.mondol.mhmh.topic;

import com.mondol.mhmh.topic.rqrs.TopicReadListRs;
import com.mondol.mhmh.topic.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
@Tag(name = "토픽 API 명세", description = "토픽과 관련된 API 리스트입니다.")
public class TopicController {
    private final TopicService topicService;

    @Operation(summary = "랜덤 토픽 리스트를 조회해옵니다.")
    @GetMapping()
    public TopicReadListRs readRandomTopic(@RequestParam(required = false, defaultValue = "5") int count) {
        return topicService.readTopicList(count);
    }

    @Operation(summary = "상황별 토픽 리스트를 조회해옵니다.")
    @GetMapping("/situation/{situation}")
    public TopicReadListRs readTopicBySituation(@PathVariable String situation, @RequestParam(required = false) int count) {
        return topicService.readTopicList(5);
    }
}

package com.mondol.mhmh.topic;

import com.mondol.mhmh.topic.rqrs.TopicReadListRs;
import com.mondol.mhmh.topic.service.TopicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
@Tag(name = "Response Estimate", description = "Response Estimate API")
public class TopicReadController {
    private final TopicService topicService;

    @GetMapping("/random")
    public TopicReadListRs randomTopicList() {
        return topicService.readTopicList(5);
    }
}

package com.mondol.mhmh.topic;

import com.mondol.mhmh.situation.schema.PersonSituationType;
import com.mondol.mhmh.situation.schema.SituationType;
import com.mondol.mhmh.topic.dto.RandomTopicReadDto;
import com.mondol.mhmh.topic.rqrs.*;
import com.mondol.mhmh.topic.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
@Tag(name = "토픽 API 명세", description = "토픽과 관련된 API 리스트입니다.")
public class TopicController {
    private final TopicService topicService;

    @Operation(summary = "랜덤 토픽 리스트를 조회해옵니다.", parameters = {
            @Parameter(name = "page"),
            @Parameter(name = "size"),
            @Parameter(name = "seed")
    })
    @GetMapping()
    public TopicReadListRs readRandomTopic(@RequestParam() int page, @RequestParam int size, @RequestParam(defaultValue = "1") int seed) {
        Page<RandomTopicReadDto> dtos = topicService.readRandomTopicList(page, size, seed);
        return TopicReadListRs.of(
                dtos.getContent().stream().map(TopicReadItemRs::from).toList(),
                page,
                size,
                (int) dtos.getTotalElements(),
                dtos.getTotalPages() - 1
        );
    }

    @Operation(summary = "상황별 토픽 리스트를 조회해옵니다.")
    @GetMapping("/situation/{situation}")
    public SituationTopicReadListRs readTopicBySituation(@PathVariable SituationType situation) {
        return SituationTopicReadListRs.of(
                situation.toString(), situation.getName(), SituationCardColor.valueOf(situation.toString()), topicService.readRandomTopicBySituation(5, situation.toString()).stream().map(SituationTopicReadItemRs::from).toList()
        );
    }

    @Operation(summary = "상황별 전체 토픽 리스트를 조회해옵니다.")
    @GetMapping("/situation/{situation}/all")
    public AllTopicReadListRs readAllTopicBySituation(@PathVariable SituationType situation) {
        List<AllTopicReadItemRs> topic = topicService.readALlTopicBySituation(situation.toString()).stream().map(AllTopicReadItemRs::from).toList();
        return AllTopicReadListRs.of(situation, topic);
    }

    @Operation(summary = "인물별 토픽 리스트를 조회해옵니다.")
    @GetMapping("/situation/person/{person}")
    public SituationTopicReadListRs readTopicBySituation(@PathVariable PersonSituationType person) {
        return null;
    }

    @Operation(summary = "인물별 전체 토픽 리스트를 조회해옵니다.")
    @GetMapping("/situation/person/{person}/all")
    public AllPersonTopicReadListRs readAllTopicBySituation(@PathVariable PersonSituationType person) {
        return null;
    }
}

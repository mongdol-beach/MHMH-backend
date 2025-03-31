package com.mondol.mhmh.situation;

import com.mondol.mhmh.situation.rqrs.SituationReadItemRs;
import com.mondol.mhmh.situation.rqrs.SituationReadListRs;
import com.mondol.mhmh.situation.service.SituationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/situation")
@RequiredArgsConstructor
@Tag(name = "상황 API 명세")
public class SituationController {
    private final SituationService situationService;

    @Operation(summary = "상황 목록을 조회해옵니다.")
    @GetMapping()
    public SituationReadListRs readSituation() {
        return SituationReadListRs.of(
                situationService.readSituationList()
                        .stream().map(SituationReadItemRs::from).toList()
        );
    }

    @Operation(summary = "인물별 상황 목록을 조회해옵니다.")
    @GetMapping("/person")
    public SituationReadListRs readPersonSituation() {
        return null;
    }
}

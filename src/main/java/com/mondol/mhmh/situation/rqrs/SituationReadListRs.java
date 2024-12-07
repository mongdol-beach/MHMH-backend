package com.mondol.mhmh.situation.rqrs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class SituationReadListRs {
    List<SituationReadItemRs> situations;
}

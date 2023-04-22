package com.openjob.model.embedded;

import com.openjob.model.entity.Skill;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateSkill {
    private Skill skill;
    private Integer yoe;
}

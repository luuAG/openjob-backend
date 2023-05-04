package com.openjob.model.dto;

import com.openjob.model.dto.shared.SkillDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateSkillDTO {
    private SkillDTO skill;
    private Integer yoe;
}

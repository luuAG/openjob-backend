package com.openjob.model.dto.shared;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobSkillDTO {
    private SkillDTO skill;
    private Integer requiredYoe;
    private Boolean mustHave;
    private Double weight;
}

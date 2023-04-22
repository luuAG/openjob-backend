package com.openjob.model.embedded;

import com.openjob.model.entity.Skill;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobSkill {
    private Skill skill;
    private Integer requiredYoe;
    private Boolean mustHave;
    private Double weight;
}

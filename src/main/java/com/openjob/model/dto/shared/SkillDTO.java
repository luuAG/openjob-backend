package com.openjob.model.dto.shared;

import com.openjob.model.dto.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillDTO extends BaseDTO {
    private String name;
    private Boolean isVerified;
}

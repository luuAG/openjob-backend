package com.openjob.model.mapper;

import com.openjob.model.dto.shared.SkillDTO;
import com.openjob.model.entity.Skill;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface SkillMapper extends BaseMapper<Skill, SkillDTO> {

}

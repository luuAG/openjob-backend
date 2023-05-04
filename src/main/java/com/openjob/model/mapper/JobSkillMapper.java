package com.openjob.model.mapper;

import com.openjob.model.dto.shared.JobSkillDTO;
import com.openjob.model.embedded.JobSkill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobSkillMapper extends BaseMapper<JobSkill, JobSkillDTO> {
}

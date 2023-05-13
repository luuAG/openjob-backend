package com.openjob.model.mapper;

import com.openjob.model.dto.shared.CandidateSkillDTO;
import com.openjob.model.embedded.CandidateSkill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateSkillMapper extends BaseMapper<CandidateSkill, CandidateSkillDTO> {
}

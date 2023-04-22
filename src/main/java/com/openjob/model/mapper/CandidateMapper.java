package com.openjob.model.mapper;

import com.openjob.model.dto.CandidateDTO;
import com.openjob.model.entity.Candidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateMapper extends BaseMapper<Candidate, CandidateDTO> {
}

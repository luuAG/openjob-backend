package com.openjob.model.mapper;

import com.openjob.model.dto.shared.JobDTO;
import com.openjob.model.entity.Job;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {JobSkillMapper.class})
public interface JobMapper extends BaseMapper<Job, JobDTO> {
}

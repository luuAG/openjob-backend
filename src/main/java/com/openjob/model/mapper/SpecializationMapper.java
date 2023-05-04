package com.openjob.model.mapper;

import com.openjob.model.dto.shared.SpecializationDTO;
import com.openjob.model.entity.Specialization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecializationMapper extends BaseMapper<Specialization, SpecializationDTO> {
}

package com.openjob.model.mapper;

import com.openjob.model.dto.CompanyDTO;
import com.openjob.model.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends BaseMapper<Company, CompanyDTO> {
}

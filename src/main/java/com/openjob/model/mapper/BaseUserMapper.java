package com.openjob.model.mapper;

import com.openjob.model.dto.base.BaseUserDTO;
import com.openjob.model.entity.base.BaseUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseUserMapper extends BaseMapper<BaseUser, BaseUserDTO> {
}

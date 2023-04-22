package com.openjob.model.mapper;

import com.openjob.model.dto.LocationDTO;
import com.openjob.model.entity.Location;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LocationMapper extends BaseMapper<Location, LocationDTO> {
}

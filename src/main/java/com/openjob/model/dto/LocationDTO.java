package com.openjob.model.dto;

import com.openjob.model.dto.base.IdentifierDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO extends IdentifierDTO {
    private String name;
}

package com.openjob.model.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO extends IdentifierDTO{
    @JsonIgnore
    protected Long createdAt;
    @JsonIgnore
    protected Long modifiedAt;
    @JsonIgnore
    protected Long deletedAt;
}

package com.openjob.model.dto.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO extends IdentifierDTO{
    protected Long createdAt;
    protected Long modifiedAt;
    protected Long deletedAt;
}

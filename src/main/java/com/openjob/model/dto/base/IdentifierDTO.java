package com.openjob.model.dto.base;

import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
public class IdentifierDTO {
    private ObjectId id;
}

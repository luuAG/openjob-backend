package com.openjob.model.entity.base;

import lombok.*;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnableMongoAuditing
public class BaseEntity extends IdentifierEntity {
    protected Long createdAt;
    protected Long modifiedAt;
    protected Long deletedAt;
}

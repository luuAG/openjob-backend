package com.openjob.model.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnableMongoAuditing
public class BaseEntity extends IdentifierEntity {
    @JsonIgnore
    protected Long createdAt;
    @JsonIgnore
    protected Long modifiedAt;
    @JsonIgnore
    protected Long deletedAt;

    protected Boolean isActive;
}

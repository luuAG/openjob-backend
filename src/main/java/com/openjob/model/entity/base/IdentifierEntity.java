package com.openjob.model.entity.base;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnableMongoAuditing
public class IdentifierEntity {
    @Id
    protected ObjectId id;

}

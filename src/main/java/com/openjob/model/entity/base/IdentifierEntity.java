package com.openjob.model.entity.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EnableMongoAuditing
public class IdentifierEntity {
    @Id
    protected String id;

}

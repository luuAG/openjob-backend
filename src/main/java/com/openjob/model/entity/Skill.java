package com.openjob.model.entity;

import com.openjob.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "skills")
public class Skill extends BaseEntity {
    private String name;
    private Boolean isVerified;

    @DBRef
    private Specialization specialization;
}

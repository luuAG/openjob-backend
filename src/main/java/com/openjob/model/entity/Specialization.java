package com.openjob.model.entity;

import com.openjob.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "specializations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Specialization extends BaseEntity {
    private String name;

    @DBRef
    private List<Skill> skills;
}

package com.openjob.model.entity;

import com.openjob.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "specializations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Specialization extends BaseEntity {
    private String name;
}

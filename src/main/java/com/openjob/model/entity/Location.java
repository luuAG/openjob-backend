package com.openjob.model.entity;

import com.openjob.model.entity.base.IdentifierEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location extends IdentifierEntity {
    private String name;
}

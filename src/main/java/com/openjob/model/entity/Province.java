package com.openjob.model.entity;

import com.openjob.model.embedded.District;
import com.openjob.model.entity.base.IdentifierEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("locations")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Province extends IdentifierEntity {
    private String name;
    private List<District> districts;
}

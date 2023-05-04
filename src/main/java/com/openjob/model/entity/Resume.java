package com.openjob.model.entity;

import com.openjob.model.embedded.Certificate;
import com.openjob.model.embedded.DynamicData;
import com.openjob.model.embedded.Education;
import com.openjob.model.embedded.Experience;
import com.openjob.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resumes")
public class Resume extends BaseEntity {
    private String resumeName;
    private Boolean isMain;

    private String objective;
    private String summary;
    private List<Education> educations;
    private List<Experience> experience;
    private List<String> languages;
    private List<Certificate> certificate;

    private List<DynamicData> optionalInformation;
}

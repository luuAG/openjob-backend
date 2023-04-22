package com.openjob.model.entity;

import com.openjob.model.common.Certificate;
import com.openjob.model.common.DynamicData;
import com.openjob.model.common.Education;
import com.openjob.model.common.Experience;
import com.openjob.model.entity.base.BaseEntity;
import com.openjob.model.enums.Language;
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
    private List<Language> languages;
    private List<Certificate> certificate;

    private List<DynamicData> optionalInformation;
}

package com.openjob.model.entity;

import com.openjob.model.common.DynamicData;
import com.openjob.model.entity.base.BaseUser;
import com.openjob.model.enums.CompanyType;
import com.openjob.model.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company extends BaseUser {
    @Indexed(unique = true)
    private String companyName;
    private String email;
    private String description;
    private Integer scope;
    private CompanyType companyType;
    private List<Language> workingLanguages;
    private List<DynamicData> optionalInformation;
    private BaseUser representative;

    @DBRef
    private List<Candidate> prefilteredCandidates;
    @DBRef
    private List<Job> jobs;
}
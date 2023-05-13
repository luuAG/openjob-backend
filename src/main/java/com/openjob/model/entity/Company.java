package com.openjob.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.openjob.model.embedded.DynamicData;
import com.openjob.model.entity.base.BaseUser;
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
    @Indexed(unique = true, sparse = true, name = "companyName")
    private String companyName;
    @Indexed(unique = true, sparse = true, name = "emailUser")
    private String email;
    private String description;
    private String scope;
    private String companyType;
    private List<String> workingLanguages;
    private List<DynamicData> optionalInformation;
    private BaseUser representative;
    private Boolean isPremium = false;

    private Double balance = (double) 0;
    private Integer amountOfJobs;
    private Integer amountOfCvViews;

    @DBRef
    @JsonIgnore
    private List<Candidate> prefilteredCandidates;
    @DBRef
    @JsonIgnore
    private List<Job> jobs;
}
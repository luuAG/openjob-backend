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
    @Indexed(unique = true)
    private String companyName;
    @Indexed(unique = true)
    private String email;
    private String description;
    private Integer scope;
    private String companyType;
    private List<String> workingLanguages;
    private List<DynamicData> optionalInformation;
    private BaseUser representative;

    @DBRef
    @JsonIgnore
    private List<Candidate> prefilteredCandidates;
    @DBRef
    private List<Job> jobs;
}
package com.openjob.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.openjob.model.embedded.JobSkill;
import com.openjob.model.embedded.SalaryInfo;
import com.openjob.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "jobs")
public class Job extends BaseEntity {
    private String title;
    private Long expiredAt;

    private String jobType;
    private String jobLevel;
    private String workplace;
    private List<String> addresses;
    private String description;
    private String requirement;
    private String benefit;
    private SalaryInfo salaryInfo;
    private Integer recruitingAmount;
    private Integer durationInDays;

    private List<JobSkill> jobSkills;

    @DBRef
    @JsonIgnore
    private Company company;

    @DBRef
    @JsonIgnore
    private List<Candidate> candidates = new ArrayList<>();
}

package com.openjob.model.entity;

import com.openjob.model.embedded.SalaryInfo;
import com.openjob.model.embedded.JobSkill;
import com.openjob.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "jobs")
public class Job extends BaseEntity {
    private String title;
    private Date expiredAt;

    private String jobType;
    private String jobLevel;
    private String workplace;
    private List<String> addresses;
    private String description;
    private String requirement;
    private String benefit;
    private SalaryInfo salaryInfo;

    private List<JobSkill> jobSkills;



}

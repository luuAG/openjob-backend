package com.openjob.model.entity;

import com.openjob.model.common.SalaryInfo;
import com.openjob.model.embedded.JobSkill;
import com.openjob.model.entity.base.BaseEntity;
import com.openjob.model.enums.JobLevel;
import com.openjob.model.enums.JobType;
import com.openjob.model.enums.Workplace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "jobs")
public class Job extends BaseEntity {
    private String title;
    private ZonedDateTime expiredAt;

    private JobType jobType;
    private JobLevel jobLevel;
    private Workplace workplace;
    private List<String> addresses;
    private String description;
    private String requirement;
    private String benefit;
    private SalaryInfo salaryInfo;

    private List<JobSkill> jobSkills;



}

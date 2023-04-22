package com.openjob.model.entity;

import com.openjob.model.common.SalaryInfo;
import com.openjob.model.embedded.CandidateSkill;
import com.openjob.model.entity.base.BaseUser;
import com.openjob.model.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class Candidate extends BaseUser {
    private JobLevel jobLevel;
    private JobType jobType;
    private SalaryInfo salaryRange;
    private List<Language> foreignLanguages;
    private CompanyType companyType;
    private Workplace workplace;

    private Boolean isHidden;
    private List<CandidateSkill> skills;

    @DBRef
    private List<Resume> resumes;

}

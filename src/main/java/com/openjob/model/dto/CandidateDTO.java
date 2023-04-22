package com.openjob.model.dto;

import com.openjob.model.common.SalaryInfo;
import com.openjob.model.dto.base.BaseUserDTO;
import com.openjob.model.embedded.CandidateSkill;
import com.openjob.model.entity.Resume;
import com.openjob.model.enums.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CandidateDTO extends BaseUserDTO {
    private JobLevel jobLevel;
    private JobType jobType;
    private SalaryInfo salaryRange;
    private List<Language> foreignLanguages;
    private CompanyType companyType;
    private Workplace workplace;

    private Boolean isHidden;
    private List<CandidateSkill> skills;
    private List<Resume> resumes;

}

package com.openjob.model.dto;

import com.openjob.model.dto.base.BaseUserDTO;
import com.openjob.model.embedded.SalaryInfo;
import com.openjob.model.entity.Resume;
import com.openjob.model.entity.Specialization;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CandidateDTO extends BaseUserDTO {
    private String jobLevel;
    private String jobType;
    private SalaryInfo salaryRange;
    private List<String> foreignLanguages;
    private String companyType;
    private String workplace;
    private Specialization specialization;

    private Boolean isHidden;
    private List<CandidateSkillDTO> skills;
    private List<Resume> resumes;

}

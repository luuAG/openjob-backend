package com.openjob.model.dto.shared;

import com.openjob.model.dto.base.BaseUserDTO;
import com.openjob.model.embedded.*;
import com.openjob.model.entity.Specialization;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CandidateDTO extends BaseUserDTO {
    private String jobTitle;
    private String jobLevel;
    private String jobType;
    private SalaryInfo salaryRange;
    private List<String> foreignLanguages;
    private String companyType;
    private String workplace;
    private Specialization specialization;
    private String objective;
    private String summary;
    private List<Education> educations;
    private List<Experience> experience;
    private List<String> languages;
    private List<Certificate> certificate;
    private List<DynamicData> optionalInformation;
    private Boolean isHidden;
    private List<CandidateSkillDTO> skills;

}

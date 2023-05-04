package com.openjob.model.dto.shared;

import com.openjob.model.dto.base.BaseDTO;
import com.openjob.model.embedded.SalaryInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class JobDTO extends BaseDTO {
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

    private List<JobSkillDTO> jobSkills;



}

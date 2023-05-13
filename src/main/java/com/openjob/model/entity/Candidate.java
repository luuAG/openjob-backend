package com.openjob.model.entity;

import com.openjob.model.dto.shared.CandidateSkillDTO;
import com.openjob.model.embedded.*;
import com.openjob.model.entity.base.BaseUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class Candidate extends BaseUser {
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

    private List<CvTemplate> cvTemplates;

}

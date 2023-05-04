package com.openjob.model.entity;

import com.openjob.model.embedded.SalaryInfo;
import com.openjob.model.dto.CandidateSkillDTO;
import com.openjob.model.entity.base.BaseUser;
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
    private String jobLevel;
    private String jobType;
    private SalaryInfo salaryRange;
    private List<String> foreignLanguages;
    private String companyType;
    private String workplace;
    private Specialization specialization;

    private Boolean isHidden;
    private List<CandidateSkillDTO> skills;

    @DBRef
    private List<Resume> resumes;

}

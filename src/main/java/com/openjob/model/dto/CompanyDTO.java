package com.openjob.model.dto;

import com.openjob.model.common.DynamicData;
import com.openjob.model.dto.base.BaseUserDTO;
import com.openjob.model.entity.Candidate;
import com.openjob.model.entity.base.BaseUser;
import com.openjob.model.enums.CompanyType;
import com.openjob.model.enums.Language;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Getter
@Setter
public class CompanyDTO extends BaseUserDTO {
    private String companyName;
    private String email;
    private String description;
    private Integer scope;
    private CompanyType companyType;
    private List<Language> workingLanguages;
    private List<DynamicData> optionalInformation;
    private BaseUser representative;

    @DBRef
    private List<Candidate> prefilteredCandidates;
}

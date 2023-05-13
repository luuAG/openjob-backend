package com.openjob.model.dto.shared;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.openjob.model.dto.base.BaseUserDTO;
import com.openjob.model.embedded.DynamicData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyDTO extends BaseUserDTO {
    private String companyName;
    private String email;
    private String description;
    private String scope;
    private String companyType;
    private List<String> workingLanguages;
    private List<DynamicData> optionalInformation;
    @JsonIgnoreProperties("account")
    private BaseUserDTO representative;


}

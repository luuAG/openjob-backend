package com.openjob.model.dto.request;

import com.openjob.model.dto.shared.CompanyDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCompanyDTO {
    private CompanyDTO company;
    private AccountDTO account;
}

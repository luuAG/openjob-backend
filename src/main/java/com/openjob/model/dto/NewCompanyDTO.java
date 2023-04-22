package com.openjob.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCompanyDTO {
    private CompanyDTO company;
    private AccountDTO account;
}

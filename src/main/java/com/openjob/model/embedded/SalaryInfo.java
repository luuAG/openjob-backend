package com.openjob.model.embedded;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryInfo {
    private Integer minSalary;
    private Integer maxSalary;
    private Boolean isNegotiated;
    private Boolean isNetSalary;
}

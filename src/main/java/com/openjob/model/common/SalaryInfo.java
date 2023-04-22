package com.openjob.model.common;

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

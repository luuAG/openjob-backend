package com.openjob.model.embedded;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Education {
    private String school;
    private String dateFrom;
    private String dateTo;
    private Double gpa;
    private String details;
}

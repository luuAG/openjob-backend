package com.openjob.model.dto.base;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BaseUserDTO extends BaseDTO {
    protected String fullName;
    protected String jobRole;
    protected Date dob;
    protected String phone;
    protected List<String> addresses;
    protected String avatarUrl;
}
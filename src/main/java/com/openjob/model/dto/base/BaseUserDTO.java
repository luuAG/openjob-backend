package com.openjob.model.dto.base;

import com.openjob.model.dto.AccountDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class BaseUserDTO extends BaseDTO {
    protected AccountDTO account;

    protected String fullName;
    protected ZonedDateTime dob;
    protected String phone;
    protected List<String> addresses;
    protected String avatarUrl;
    protected String role;
}
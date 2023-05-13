package com.openjob.model.dto.request;

import com.openjob.model.dto.base.BaseDTO;
import com.openjob.model.dto.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO extends BaseDTO {
    private String username;
    private String password;
    private Role role;
}

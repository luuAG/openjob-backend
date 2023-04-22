package com.openjob.model.dto;

import com.openjob.model.dto.base.BaseUserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewAdminDTO {
    private BaseUserDTO admin;
    private AccountDTO account;
}

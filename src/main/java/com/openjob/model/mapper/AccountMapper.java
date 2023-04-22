package com.openjob.model.mapper;

import com.openjob.model.dto.AccountDTO;
import com.openjob.model.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountDTO> {
}

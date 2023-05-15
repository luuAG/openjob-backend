package com.openjob.model.mapper;

import com.openjob.model.dto.request.AccountDTO;
import com.openjob.model.entity.Account;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T22:32:10+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountDTO toDTO(Account entity) {
        if ( entity == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId( entity.getId() );
        accountDTO.setCreatedAt( entity.getCreatedAt() );
        accountDTO.setModifiedAt( entity.getModifiedAt() );
        accountDTO.setDeletedAt( entity.getDeletedAt() );
        accountDTO.setIsActive( entity.getIsActive() );
        accountDTO.setUsername( entity.getUsername() );
        accountDTO.setPassword( entity.getPassword() );
        accountDTO.setRole( entity.getRole() );

        return accountDTO;
    }

    @Override
    public Account toEntity(AccountDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( dto.getId() );
        account.setCreatedAt( dto.getCreatedAt() );
        account.setModifiedAt( dto.getModifiedAt() );
        account.setDeletedAt( dto.getDeletedAt() );
        account.setIsActive( dto.getIsActive() );
        account.setUsername( dto.getUsername() );
        account.setPassword( dto.getPassword() );
        account.setRole( dto.getRole() );

        return account;
    }

    @Override
    public List<AccountDTO> toDTO(List<Account> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AccountDTO> list = new ArrayList<AccountDTO>( entities.size() );
        for ( Account account : entities ) {
            list.add( toDTO( account ) );
        }

        return list;
    }

    @Override
    public List<Account> toEntity(List<AccountDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Account> list = new ArrayList<Account>( dtoList.size() );
        for ( AccountDTO accountDTO : dtoList ) {
            list.add( toEntity( accountDTO ) );
        }

        return list;
    }
}

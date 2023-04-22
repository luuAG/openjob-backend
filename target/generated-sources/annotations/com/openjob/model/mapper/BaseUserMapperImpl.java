package com.openjob.model.mapper;

import com.openjob.model.dto.AccountDTO;
import com.openjob.model.dto.base.BaseUserDTO;
import com.openjob.model.entity.Account;
import com.openjob.model.entity.base.BaseUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T10:53:11+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class BaseUserMapperImpl implements BaseUserMapper {

    @Override
    public BaseUserDTO toDTO(BaseUser entity) {
        if ( entity == null ) {
            return null;
        }

        BaseUserDTO baseUserDTO = new BaseUserDTO();

        baseUserDTO.setId( entity.getId() );
        baseUserDTO.setCreatedAt( entity.getCreatedAt() );
        baseUserDTO.setModifiedAt( entity.getModifiedAt() );
        baseUserDTO.setDeletedAt( entity.getDeletedAt() );
        baseUserDTO.setAccount( accountToAccountDTO( entity.getAccount() ) );
        baseUserDTO.setFullName( entity.getFullName() );
        baseUserDTO.setDob( entity.getDob() );
        baseUserDTO.setPhone( entity.getPhone() );
        List<String> list = entity.getAddresses();
        if ( list != null ) {
            baseUserDTO.setAddresses( new ArrayList<String>( list ) );
        }
        baseUserDTO.setAvatarUrl( entity.getAvatarUrl() );
        baseUserDTO.setRole( entity.getRole() );

        return baseUserDTO;
    }

    @Override
    public BaseUser toEntity(BaseUserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BaseUser baseUser = new BaseUser();

        baseUser.setId( dto.getId() );
        baseUser.setCreatedAt( dto.getCreatedAt() );
        baseUser.setModifiedAt( dto.getModifiedAt() );
        baseUser.setDeletedAt( dto.getDeletedAt() );
        baseUser.setAccount( accountDTOToAccount( dto.getAccount() ) );
        baseUser.setFullName( dto.getFullName() );
        baseUser.setDob( dto.getDob() );
        baseUser.setPhone( dto.getPhone() );
        List<String> list = dto.getAddresses();
        if ( list != null ) {
            baseUser.setAddresses( new ArrayList<String>( list ) );
        }
        baseUser.setAvatarUrl( dto.getAvatarUrl() );
        baseUser.setRole( dto.getRole() );

        return baseUser;
    }

    @Override
    public List<BaseUserDTO> toDTO(List<BaseUser> entities) {
        if ( entities == null ) {
            return null;
        }

        List<BaseUserDTO> list = new ArrayList<BaseUserDTO>( entities.size() );
        for ( BaseUser baseUser : entities ) {
            list.add( toDTO( baseUser ) );
        }

        return list;
    }

    @Override
    public List<BaseUser> toEntity(List<BaseUserDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BaseUser> list = new ArrayList<BaseUser>( dtoList.size() );
        for ( BaseUserDTO baseUserDTO : dtoList ) {
            list.add( toEntity( baseUserDTO ) );
        }

        return list;
    }

    protected AccountDTO accountToAccountDTO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId( account.getId() );
        accountDTO.setCreatedAt( account.getCreatedAt() );
        accountDTO.setModifiedAt( account.getModifiedAt() );
        accountDTO.setDeletedAt( account.getDeletedAt() );
        accountDTO.setUsername( account.getUsername() );
        accountDTO.setPassword( account.getPassword() );
        accountDTO.setRole( account.getRole() );

        return accountDTO;
    }

    protected Account accountDTOToAccount(AccountDTO accountDTO) {
        if ( accountDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountDTO.getId() );
        account.setCreatedAt( accountDTO.getCreatedAt() );
        account.setModifiedAt( accountDTO.getModifiedAt() );
        account.setDeletedAt( accountDTO.getDeletedAt() );
        account.setUsername( accountDTO.getUsername() );
        account.setPassword( accountDTO.getPassword() );
        account.setRole( accountDTO.getRole() );

        return account;
    }
}

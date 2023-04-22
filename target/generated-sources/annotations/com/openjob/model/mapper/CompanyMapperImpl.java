package com.openjob.model.mapper;

import com.openjob.model.common.DynamicData;
import com.openjob.model.dto.AccountDTO;
import com.openjob.model.dto.CompanyDTO;
import com.openjob.model.entity.Account;
import com.openjob.model.entity.Candidate;
import com.openjob.model.entity.Company;
import com.openjob.model.enums.Language;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T17:48:12+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyDTO toDTO(Company entity) {
        if ( entity == null ) {
            return null;
        }

        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setId( entity.getId() );
        companyDTO.setCreatedAt( entity.getCreatedAt() );
        companyDTO.setModifiedAt( entity.getModifiedAt() );
        companyDTO.setDeletedAt( entity.getDeletedAt() );
        companyDTO.setAccount( accountToAccountDTO( entity.getAccount() ) );
        companyDTO.setFullName( entity.getFullName() );
        companyDTO.setDob( entity.getDob() );
        companyDTO.setPhone( entity.getPhone() );
        List<String> list = entity.getAddresses();
        if ( list != null ) {
            companyDTO.setAddresses( new ArrayList<String>( list ) );
        }
        companyDTO.setAvatarUrl( entity.getAvatarUrl() );
        companyDTO.setRole( entity.getRole() );
        companyDTO.setCompanyName( entity.getCompanyName() );
        companyDTO.setEmail( entity.getEmail() );
        companyDTO.setDescription( entity.getDescription() );
        companyDTO.setScope( entity.getScope() );
        companyDTO.setCompanyType( entity.getCompanyType() );
        List<Language> list1 = entity.getWorkingLanguages();
        if ( list1 != null ) {
            companyDTO.setWorkingLanguages( new ArrayList<Language>( list1 ) );
        }
        List<DynamicData> list2 = entity.getOptionalInformation();
        if ( list2 != null ) {
            companyDTO.setOptionalInformation( new ArrayList<DynamicData>( list2 ) );
        }
        companyDTO.setRepresentative( entity.getRepresentative() );
        List<Candidate> list3 = entity.getPrefilteredCandidates();
        if ( list3 != null ) {
            companyDTO.setPrefilteredCandidates( new ArrayList<Candidate>( list3 ) );
        }

        return companyDTO;
    }

    @Override
    public Company toEntity(CompanyDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( dto.getId() );
        company.setCreatedAt( dto.getCreatedAt() );
        company.setModifiedAt( dto.getModifiedAt() );
        company.setDeletedAt( dto.getDeletedAt() );
        company.setAccount( accountDTOToAccount( dto.getAccount() ) );
        company.setFullName( dto.getFullName() );
        company.setDob( dto.getDob() );
        company.setPhone( dto.getPhone() );
        List<String> list = dto.getAddresses();
        if ( list != null ) {
            company.setAddresses( new ArrayList<String>( list ) );
        }
        company.setAvatarUrl( dto.getAvatarUrl() );
        company.setRole( dto.getRole() );
        company.setCompanyName( dto.getCompanyName() );
        company.setEmail( dto.getEmail() );
        company.setDescription( dto.getDescription() );
        company.setScope( dto.getScope() );
        company.setCompanyType( dto.getCompanyType() );
        List<Language> list1 = dto.getWorkingLanguages();
        if ( list1 != null ) {
            company.setWorkingLanguages( new ArrayList<Language>( list1 ) );
        }
        List<DynamicData> list2 = dto.getOptionalInformation();
        if ( list2 != null ) {
            company.setOptionalInformation( new ArrayList<DynamicData>( list2 ) );
        }
        company.setRepresentative( dto.getRepresentative() );
        List<Candidate> list3 = dto.getPrefilteredCandidates();
        if ( list3 != null ) {
            company.setPrefilteredCandidates( new ArrayList<Candidate>( list3 ) );
        }

        return company;
    }

    @Override
    public List<CompanyDTO> toDTO(List<Company> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CompanyDTO> list = new ArrayList<CompanyDTO>( entities.size() );
        for ( Company company : entities ) {
            list.add( toDTO( company ) );
        }

        return list;
    }

    @Override
    public List<Company> toEntity(List<CompanyDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Company> list = new ArrayList<Company>( dtoList.size() );
        for ( CompanyDTO companyDTO : dtoList ) {
            list.add( toEntity( companyDTO ) );
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

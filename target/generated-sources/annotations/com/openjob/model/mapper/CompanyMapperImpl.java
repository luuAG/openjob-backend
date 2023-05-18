package com.openjob.model.mapper;

import com.openjob.model.dto.base.BaseUserDTO;
import com.openjob.model.dto.shared.CompanyDTO;
import com.openjob.model.embedded.DynamicData;
import com.openjob.model.entity.Company;
import com.openjob.model.entity.base.BaseUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T23:03:45+0700",
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
        companyDTO.setIsActive( entity.getIsActive() );
        companyDTO.setFullName( entity.getFullName() );
        companyDTO.setJobRole( entity.getJobRole() );
        companyDTO.setDob( entity.getDob() );
        companyDTO.setPhone( entity.getPhone() );
        List<String> list = entity.getAddresses();
        if ( list != null ) {
            companyDTO.setAddresses( new ArrayList<String>( list ) );
        }
        companyDTO.setAvatarUrl( entity.getAvatarUrl() );
        companyDTO.setCompanyName( entity.getCompanyName() );
        companyDTO.setEmail( entity.getEmail() );
        companyDTO.setDescription( entity.getDescription() );
        companyDTO.setScope( entity.getScope() );
        companyDTO.setCompanyType( entity.getCompanyType() );
        List<String> list1 = entity.getWorkingLanguages();
        if ( list1 != null ) {
            companyDTO.setWorkingLanguages( new ArrayList<String>( list1 ) );
        }
        List<DynamicData> list2 = entity.getOptionalInformation();
        if ( list2 != null ) {
            companyDTO.setOptionalInformation( new ArrayList<DynamicData>( list2 ) );
        }
        companyDTO.setRepresentative( baseUserToBaseUserDTO( entity.getRepresentative() ) );

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
        company.setIsActive( dto.getIsActive() );
        company.setFullName( dto.getFullName() );
        company.setJobRole( dto.getJobRole() );
        company.setDob( dto.getDob() );
        company.setPhone( dto.getPhone() );
        List<String> list = dto.getAddresses();
        if ( list != null ) {
            company.setAddresses( new ArrayList<String>( list ) );
        }
        company.setAvatarUrl( dto.getAvatarUrl() );
        company.setCompanyName( dto.getCompanyName() );
        company.setEmail( dto.getEmail() );
        company.setDescription( dto.getDescription() );
        company.setScope( dto.getScope() );
        company.setCompanyType( dto.getCompanyType() );
        List<String> list1 = dto.getWorkingLanguages();
        if ( list1 != null ) {
            company.setWorkingLanguages( new ArrayList<String>( list1 ) );
        }
        List<DynamicData> list2 = dto.getOptionalInformation();
        if ( list2 != null ) {
            company.setOptionalInformation( new ArrayList<DynamicData>( list2 ) );
        }
        company.setRepresentative( baseUserDTOToBaseUser( dto.getRepresentative() ) );

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

    protected BaseUserDTO baseUserToBaseUserDTO(BaseUser baseUser) {
        if ( baseUser == null ) {
            return null;
        }

        BaseUserDTO baseUserDTO = new BaseUserDTO();

        baseUserDTO.setId( baseUser.getId() );
        baseUserDTO.setCreatedAt( baseUser.getCreatedAt() );
        baseUserDTO.setModifiedAt( baseUser.getModifiedAt() );
        baseUserDTO.setDeletedAt( baseUser.getDeletedAt() );
        baseUserDTO.setIsActive( baseUser.getIsActive() );
        baseUserDTO.setFullName( baseUser.getFullName() );
        baseUserDTO.setJobRole( baseUser.getJobRole() );
        baseUserDTO.setDob( baseUser.getDob() );
        baseUserDTO.setPhone( baseUser.getPhone() );
        List<String> list = baseUser.getAddresses();
        if ( list != null ) {
            baseUserDTO.setAddresses( new ArrayList<String>( list ) );
        }
        baseUserDTO.setAvatarUrl( baseUser.getAvatarUrl() );

        return baseUserDTO;
    }

    protected BaseUser baseUserDTOToBaseUser(BaseUserDTO baseUserDTO) {
        if ( baseUserDTO == null ) {
            return null;
        }

        BaseUser baseUser = new BaseUser();

        baseUser.setId( baseUserDTO.getId() );
        baseUser.setCreatedAt( baseUserDTO.getCreatedAt() );
        baseUser.setModifiedAt( baseUserDTO.getModifiedAt() );
        baseUser.setDeletedAt( baseUserDTO.getDeletedAt() );
        baseUser.setIsActive( baseUserDTO.getIsActive() );
        baseUser.setFullName( baseUserDTO.getFullName() );
        baseUser.setJobRole( baseUserDTO.getJobRole() );
        baseUser.setDob( baseUserDTO.getDob() );
        baseUser.setPhone( baseUserDTO.getPhone() );
        List<String> list = baseUserDTO.getAddresses();
        if ( list != null ) {
            baseUser.setAddresses( new ArrayList<String>( list ) );
        }
        baseUser.setAvatarUrl( baseUserDTO.getAvatarUrl() );

        return baseUser;
    }
}

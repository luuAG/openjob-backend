package com.openjob.model.mapper;

import com.openjob.model.dto.AccountDTO;
import com.openjob.model.dto.CandidateDTO;
import com.openjob.model.embedded.CandidateSkill;
import com.openjob.model.entity.Account;
import com.openjob.model.entity.Candidate;
import com.openjob.model.entity.Resume;
import com.openjob.model.enums.Language;
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
public class CandidateMapperImpl implements CandidateMapper {

    @Override
    public CandidateDTO toDTO(Candidate entity) {
        if ( entity == null ) {
            return null;
        }

        CandidateDTO candidateDTO = new CandidateDTO();

        candidateDTO.setId( entity.getId() );
        candidateDTO.setCreatedAt( entity.getCreatedAt() );
        candidateDTO.setModifiedAt( entity.getModifiedAt() );
        candidateDTO.setDeletedAt( entity.getDeletedAt() );
        candidateDTO.setAccount( accountToAccountDTO( entity.getAccount() ) );
        candidateDTO.setFullName( entity.getFullName() );
        candidateDTO.setDob( entity.getDob() );
        candidateDTO.setPhone( entity.getPhone() );
        List<String> list = entity.getAddresses();
        if ( list != null ) {
            candidateDTO.setAddresses( new ArrayList<String>( list ) );
        }
        candidateDTO.setAvatarUrl( entity.getAvatarUrl() );
        candidateDTO.setRole( entity.getRole() );
        candidateDTO.setJobLevel( entity.getJobLevel() );
        candidateDTO.setJobType( entity.getJobType() );
        candidateDTO.setSalaryRange( entity.getSalaryRange() );
        List<Language> list1 = entity.getForeignLanguages();
        if ( list1 != null ) {
            candidateDTO.setForeignLanguages( new ArrayList<Language>( list1 ) );
        }
        candidateDTO.setCompanyType( entity.getCompanyType() );
        candidateDTO.setWorkplace( entity.getWorkplace() );
        candidateDTO.setIsHidden( entity.getIsHidden() );
        List<CandidateSkill> list2 = entity.getSkills();
        if ( list2 != null ) {
            candidateDTO.setSkills( new ArrayList<CandidateSkill>( list2 ) );
        }
        List<Resume> list3 = entity.getResumes();
        if ( list3 != null ) {
            candidateDTO.setResumes( new ArrayList<Resume>( list3 ) );
        }

        return candidateDTO;
    }

    @Override
    public Candidate toEntity(CandidateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Candidate candidate = new Candidate();

        candidate.setId( dto.getId() );
        candidate.setCreatedAt( dto.getCreatedAt() );
        candidate.setModifiedAt( dto.getModifiedAt() );
        candidate.setDeletedAt( dto.getDeletedAt() );
        candidate.setAccount( accountDTOToAccount( dto.getAccount() ) );
        candidate.setFullName( dto.getFullName() );
        candidate.setDob( dto.getDob() );
        candidate.setPhone( dto.getPhone() );
        List<String> list = dto.getAddresses();
        if ( list != null ) {
            candidate.setAddresses( new ArrayList<String>( list ) );
        }
        candidate.setAvatarUrl( dto.getAvatarUrl() );
        candidate.setRole( dto.getRole() );
        candidate.setJobLevel( dto.getJobLevel() );
        candidate.setJobType( dto.getJobType() );
        candidate.setSalaryRange( dto.getSalaryRange() );
        List<Language> list1 = dto.getForeignLanguages();
        if ( list1 != null ) {
            candidate.setForeignLanguages( new ArrayList<Language>( list1 ) );
        }
        candidate.setCompanyType( dto.getCompanyType() );
        candidate.setWorkplace( dto.getWorkplace() );
        candidate.setIsHidden( dto.getIsHidden() );
        List<CandidateSkill> list2 = dto.getSkills();
        if ( list2 != null ) {
            candidate.setSkills( new ArrayList<CandidateSkill>( list2 ) );
        }
        List<Resume> list3 = dto.getResumes();
        if ( list3 != null ) {
            candidate.setResumes( new ArrayList<Resume>( list3 ) );
        }

        return candidate;
    }

    @Override
    public List<CandidateDTO> toDTO(List<Candidate> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CandidateDTO> list = new ArrayList<CandidateDTO>( entities.size() );
        for ( Candidate candidate : entities ) {
            list.add( toDTO( candidate ) );
        }

        return list;
    }

    @Override
    public List<Candidate> toEntity(List<CandidateDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Candidate> list = new ArrayList<Candidate>( dtoList.size() );
        for ( CandidateDTO candidateDTO : dtoList ) {
            list.add( toEntity( candidateDTO ) );
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

package com.openjob.model.mapper;

import com.openjob.model.dto.shared.CandidateDTO;
import com.openjob.model.dto.shared.CandidateSkillDTO;
import com.openjob.model.embedded.Certificate;
import com.openjob.model.embedded.DynamicData;
import com.openjob.model.embedded.Education;
import com.openjob.model.embedded.Experience;
import com.openjob.model.entity.Candidate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T22:32:12+0700",
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
        candidateDTO.setIsActive( entity.getIsActive() );
        candidateDTO.setFullName( entity.getFullName() );
        candidateDTO.setJobRole( entity.getJobRole() );
        candidateDTO.setDob( entity.getDob() );
        candidateDTO.setPhone( entity.getPhone() );
        List<String> list = entity.getAddresses();
        if ( list != null ) {
            candidateDTO.setAddresses( new ArrayList<String>( list ) );
        }
        candidateDTO.setAvatarUrl( entity.getAvatarUrl() );
        candidateDTO.setJobTitle( entity.getJobTitle() );
        candidateDTO.setJobLevel( entity.getJobLevel() );
        candidateDTO.setJobType( entity.getJobType() );
        candidateDTO.setSalaryRange( entity.getSalaryRange() );
        List<String> list1 = entity.getForeignLanguages();
        if ( list1 != null ) {
            candidateDTO.setForeignLanguages( new ArrayList<String>( list1 ) );
        }
        candidateDTO.setCompanyType( entity.getCompanyType() );
        candidateDTO.setWorkplace( entity.getWorkplace() );
        candidateDTO.setSpecialization( entity.getSpecialization() );
        candidateDTO.setObjective( entity.getObjective() );
        candidateDTO.setSummary( entity.getSummary() );
        List<Education> list2 = entity.getEducations();
        if ( list2 != null ) {
            candidateDTO.setEducations( new ArrayList<Education>( list2 ) );
        }
        List<Experience> list3 = entity.getExperience();
        if ( list3 != null ) {
            candidateDTO.setExperience( new ArrayList<Experience>( list3 ) );
        }
        List<String> list4 = entity.getLanguages();
        if ( list4 != null ) {
            candidateDTO.setLanguages( new ArrayList<String>( list4 ) );
        }
        List<Certificate> list5 = entity.getCertificate();
        if ( list5 != null ) {
            candidateDTO.setCertificate( new ArrayList<Certificate>( list5 ) );
        }
        List<DynamicData> list6 = entity.getOptionalInformation();
        if ( list6 != null ) {
            candidateDTO.setOptionalInformation( new ArrayList<DynamicData>( list6 ) );
        }
        candidateDTO.setIsHidden( entity.getIsHidden() );
        List<CandidateSkillDTO> list7 = entity.getSkills();
        if ( list7 != null ) {
            candidateDTO.setSkills( new ArrayList<CandidateSkillDTO>( list7 ) );
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
        candidate.setIsActive( dto.getIsActive() );
        candidate.setFullName( dto.getFullName() );
        candidate.setJobRole( dto.getJobRole() );
        candidate.setDob( dto.getDob() );
        candidate.setPhone( dto.getPhone() );
        List<String> list = dto.getAddresses();
        if ( list != null ) {
            candidate.setAddresses( new ArrayList<String>( list ) );
        }
        candidate.setAvatarUrl( dto.getAvatarUrl() );
        candidate.setJobTitle( dto.getJobTitle() );
        candidate.setJobLevel( dto.getJobLevel() );
        candidate.setJobType( dto.getJobType() );
        candidate.setSalaryRange( dto.getSalaryRange() );
        List<String> list1 = dto.getForeignLanguages();
        if ( list1 != null ) {
            candidate.setForeignLanguages( new ArrayList<String>( list1 ) );
        }
        candidate.setCompanyType( dto.getCompanyType() );
        candidate.setWorkplace( dto.getWorkplace() );
        candidate.setSpecialization( dto.getSpecialization() );
        candidate.setObjective( dto.getObjective() );
        candidate.setSummary( dto.getSummary() );
        List<Education> list2 = dto.getEducations();
        if ( list2 != null ) {
            candidate.setEducations( new ArrayList<Education>( list2 ) );
        }
        List<Experience> list3 = dto.getExperience();
        if ( list3 != null ) {
            candidate.setExperience( new ArrayList<Experience>( list3 ) );
        }
        List<String> list4 = dto.getLanguages();
        if ( list4 != null ) {
            candidate.setLanguages( new ArrayList<String>( list4 ) );
        }
        List<Certificate> list5 = dto.getCertificate();
        if ( list5 != null ) {
            candidate.setCertificate( new ArrayList<Certificate>( list5 ) );
        }
        List<DynamicData> list6 = dto.getOptionalInformation();
        if ( list6 != null ) {
            candidate.setOptionalInformation( new ArrayList<DynamicData>( list6 ) );
        }
        candidate.setIsHidden( dto.getIsHidden() );
        List<CandidateSkillDTO> list7 = dto.getSkills();
        if ( list7 != null ) {
            candidate.setSkills( new ArrayList<CandidateSkillDTO>( list7 ) );
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
}

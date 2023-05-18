package com.openjob.model.mapper;

import com.openjob.model.dto.shared.CandidateSkillDTO;
import com.openjob.model.dto.shared.SkillDTO;
import com.openjob.model.embedded.CandidateSkill;
import com.openjob.model.entity.Skill;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T23:03:44+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class CandidateSkillMapperImpl implements CandidateSkillMapper {

    @Override
    public CandidateSkillDTO toDTO(CandidateSkill entity) {
        if ( entity == null ) {
            return null;
        }

        CandidateSkillDTO candidateSkillDTO = new CandidateSkillDTO();

        candidateSkillDTO.setSkill( skillToSkillDTO( entity.getSkill() ) );
        candidateSkillDTO.setYoe( entity.getYoe() );

        return candidateSkillDTO;
    }

    @Override
    public CandidateSkill toEntity(CandidateSkillDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CandidateSkill candidateSkill = new CandidateSkill();

        candidateSkill.setSkill( skillDTOToSkill( dto.getSkill() ) );
        candidateSkill.setYoe( dto.getYoe() );

        return candidateSkill;
    }

    @Override
    public List<CandidateSkillDTO> toDTO(List<CandidateSkill> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CandidateSkillDTO> list = new ArrayList<CandidateSkillDTO>( entities.size() );
        for ( CandidateSkill candidateSkill : entities ) {
            list.add( toDTO( candidateSkill ) );
        }

        return list;
    }

    @Override
    public List<CandidateSkill> toEntity(List<CandidateSkillDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<CandidateSkill> list = new ArrayList<CandidateSkill>( dtoList.size() );
        for ( CandidateSkillDTO candidateSkillDTO : dtoList ) {
            list.add( toEntity( candidateSkillDTO ) );
        }

        return list;
    }

    protected SkillDTO skillToSkillDTO(Skill skill) {
        if ( skill == null ) {
            return null;
        }

        SkillDTO skillDTO = new SkillDTO();

        skillDTO.setId( skill.getId() );
        skillDTO.setCreatedAt( skill.getCreatedAt() );
        skillDTO.setModifiedAt( skill.getModifiedAt() );
        skillDTO.setDeletedAt( skill.getDeletedAt() );
        skillDTO.setIsActive( skill.getIsActive() );
        skillDTO.setName( skill.getName() );
        skillDTO.setIsVerified( skill.getIsVerified() );

        return skillDTO;
    }

    protected Skill skillDTOToSkill(SkillDTO skillDTO) {
        if ( skillDTO == null ) {
            return null;
        }

        Skill skill = new Skill();

        skill.setId( skillDTO.getId() );
        skill.setCreatedAt( skillDTO.getCreatedAt() );
        skill.setModifiedAt( skillDTO.getModifiedAt() );
        skill.setDeletedAt( skillDTO.getDeletedAt() );
        skill.setIsActive( skillDTO.getIsActive() );
        skill.setName( skillDTO.getName() );
        skill.setIsVerified( skillDTO.getIsVerified() );

        return skill;
    }
}

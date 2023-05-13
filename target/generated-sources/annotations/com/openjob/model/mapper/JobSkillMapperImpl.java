package com.openjob.model.mapper;

import com.openjob.model.dto.shared.JobSkillDTO;
import com.openjob.model.dto.shared.SkillDTO;
import com.openjob.model.embedded.JobSkill;
import com.openjob.model.entity.Skill;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-12T00:15:21+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class JobSkillMapperImpl implements JobSkillMapper {

    @Override
    public JobSkillDTO toDTO(JobSkill entity) {
        if ( entity == null ) {
            return null;
        }

        JobSkillDTO jobSkillDTO = new JobSkillDTO();

        jobSkillDTO.setSkill( skillToSkillDTO( entity.getSkill() ) );
        jobSkillDTO.setRequiredYoe( entity.getRequiredYoe() );
        jobSkillDTO.setMustHave( entity.getMustHave() );
        jobSkillDTO.setWeight( entity.getWeight() );

        return jobSkillDTO;
    }

    @Override
    public JobSkill toEntity(JobSkillDTO dto) {
        if ( dto == null ) {
            return null;
        }

        JobSkill jobSkill = new JobSkill();

        jobSkill.setSkill( skillDTOToSkill( dto.getSkill() ) );
        jobSkill.setRequiredYoe( dto.getRequiredYoe() );
        jobSkill.setMustHave( dto.getMustHave() );
        jobSkill.setWeight( dto.getWeight() );

        return jobSkill;
    }

    @Override
    public List<JobSkillDTO> toDTO(List<JobSkill> entities) {
        if ( entities == null ) {
            return null;
        }

        List<JobSkillDTO> list = new ArrayList<JobSkillDTO>( entities.size() );
        for ( JobSkill jobSkill : entities ) {
            list.add( toDTO( jobSkill ) );
        }

        return list;
    }

    @Override
    public List<JobSkill> toEntity(List<JobSkillDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<JobSkill> list = new ArrayList<JobSkill>( dtoList.size() );
        for ( JobSkillDTO jobSkillDTO : dtoList ) {
            list.add( toEntity( jobSkillDTO ) );
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
        skill.setName( skillDTO.getName() );
        skill.setIsVerified( skillDTO.getIsVerified() );

        return skill;
    }
}

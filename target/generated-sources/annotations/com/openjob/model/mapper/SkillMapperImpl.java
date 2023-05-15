package com.openjob.model.mapper;

import com.openjob.model.dto.shared.SkillDTO;
import com.openjob.model.entity.Skill;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T22:32:11+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class SkillMapperImpl implements SkillMapper {

    @Override
    public SkillDTO toDTO(Skill entity) {
        if ( entity == null ) {
            return null;
        }

        SkillDTO skillDTO = new SkillDTO();

        skillDTO.setId( entity.getId() );
        skillDTO.setCreatedAt( entity.getCreatedAt() );
        skillDTO.setModifiedAt( entity.getModifiedAt() );
        skillDTO.setDeletedAt( entity.getDeletedAt() );
        skillDTO.setIsActive( entity.getIsActive() );
        skillDTO.setName( entity.getName() );
        skillDTO.setIsVerified( entity.getIsVerified() );

        return skillDTO;
    }

    @Override
    public Skill toEntity(SkillDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Skill skill = new Skill();

        skill.setId( dto.getId() );
        skill.setCreatedAt( dto.getCreatedAt() );
        skill.setModifiedAt( dto.getModifiedAt() );
        skill.setDeletedAt( dto.getDeletedAt() );
        skill.setIsActive( dto.getIsActive() );
        skill.setName( dto.getName() );
        skill.setIsVerified( dto.getIsVerified() );

        return skill;
    }

    @Override
    public List<SkillDTO> toDTO(List<Skill> entities) {
        if ( entities == null ) {
            return null;
        }

        List<SkillDTO> list = new ArrayList<SkillDTO>( entities.size() );
        for ( Skill skill : entities ) {
            list.add( toDTO( skill ) );
        }

        return list;
    }

    @Override
    public List<Skill> toEntity(List<SkillDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Skill> list = new ArrayList<Skill>( dtoList.size() );
        for ( SkillDTO skillDTO : dtoList ) {
            list.add( toEntity( skillDTO ) );
        }

        return list;
    }
}

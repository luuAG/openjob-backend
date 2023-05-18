package com.openjob.model.mapper;

import com.openjob.model.dto.shared.SpecializationDTO;
import com.openjob.model.entity.Specialization;
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
public class SpecializationMapperImpl implements SpecializationMapper {

    @Override
    public SpecializationDTO toDTO(Specialization entity) {
        if ( entity == null ) {
            return null;
        }

        SpecializationDTO specializationDTO = new SpecializationDTO();

        specializationDTO.setId( entity.getId() );
        specializationDTO.setCreatedAt( entity.getCreatedAt() );
        specializationDTO.setModifiedAt( entity.getModifiedAt() );
        specializationDTO.setDeletedAt( entity.getDeletedAt() );
        specializationDTO.setIsActive( entity.getIsActive() );
        specializationDTO.setName( entity.getName() );

        return specializationDTO;
    }

    @Override
    public Specialization toEntity(SpecializationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Specialization specialization = new Specialization();

        specialization.setId( dto.getId() );
        specialization.setCreatedAt( dto.getCreatedAt() );
        specialization.setModifiedAt( dto.getModifiedAt() );
        specialization.setDeletedAt( dto.getDeletedAt() );
        specialization.setIsActive( dto.getIsActive() );
        specialization.setName( dto.getName() );

        return specialization;
    }

    @Override
    public List<SpecializationDTO> toDTO(List<Specialization> entities) {
        if ( entities == null ) {
            return null;
        }

        List<SpecializationDTO> list = new ArrayList<SpecializationDTO>( entities.size() );
        for ( Specialization specialization : entities ) {
            list.add( toDTO( specialization ) );
        }

        return list;
    }

    @Override
    public List<Specialization> toEntity(List<SpecializationDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Specialization> list = new ArrayList<Specialization>( dtoList.size() );
        for ( SpecializationDTO specializationDTO : dtoList ) {
            list.add( toEntity( specializationDTO ) );
        }

        return list;
    }
}

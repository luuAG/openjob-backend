package com.openjob.model.mapper;

import com.openjob.model.dto.LocationDTO;
import com.openjob.model.entity.Location;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-16T10:53:10+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationDTO toDTO(Location entity) {
        if ( entity == null ) {
            return null;
        }

        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setId( entity.getId() );
        locationDTO.setName( entity.getName() );

        return locationDTO;
    }

    @Override
    public Location toEntity(LocationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Location location = new Location();

        location.setId( dto.getId() );
        location.setName( dto.getName() );

        return location;
    }

    @Override
    public List<LocationDTO> toDTO(List<Location> entities) {
        if ( entities == null ) {
            return null;
        }

        List<LocationDTO> list = new ArrayList<LocationDTO>( entities.size() );
        for ( Location location : entities ) {
            list.add( toDTO( location ) );
        }

        return list;
    }

    @Override
    public List<Location> toEntity(List<LocationDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Location> list = new ArrayList<Location>( dtoList.size() );
        for ( LocationDTO locationDTO : dtoList ) {
            list.add( toEntity( locationDTO ) );
        }

        return list;
    }
}

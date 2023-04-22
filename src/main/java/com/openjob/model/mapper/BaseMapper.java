package com.openjob.model.mapper;

import java.util.List;

public interface BaseMapper<E, D> {
    D toDTO(E entity);

    E toEntity(D dto);

    List<D> toDTO(List<E> entities);

    List<E> toEntity(List<D> dtoList);
}

package com.openjob.service;

import com.openjob.constant.ErrorMessage;
import com.openjob.model.entity.base.BaseEntity;
import com.openjob.model.entity.base.IdentifierEntity;
import com.openjob.util.NullAwareBeanUtils;
import io.github.ajclopez.mss.MongoSpringSearch;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class BaseService<E, ID> {
    protected Class<E> clazz;
    protected MongoRepository<E, ID> repository;
    protected MongoTemplate baseMongoTemplate;

    // inject repository and mongoTemplate here
    @PostConstruct
    protected abstract void init();

    public E getById(ID id) {
        Optional<E> entity = repository.findById(id);
        return entity.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, null));
    }

    public List<E> getAll(String query) {
        return baseMongoTemplate.find(MongoSpringSearch.mss(query), clazz);
    }

    public E saveUpdate(E entity, ID id) {
        if (Objects.isNull(((IdentifierEntity) entity).getId()))
            return save(entity);
        return update(entity, id);
    }

    public boolean deleteById(ID id) {
        Optional<E> entity = repository.findById(id);
        if (entity.isPresent()) {
            beforeDelete(entity.get());
            repository.deleteById(id);
            return !repository.existsById(id);
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, null);

    }

    public boolean softDeleteById(ID id) {
        Optional<E> entity = repository.findById(id);
        if (entity.isPresent()) {
            if (entity.get() instanceof BaseEntity baseEntity){
                if (Objects.isNull(baseEntity.getDeletedAt())){
                    Long now = new Date().getTime();
                    baseEntity.setDeletedAt(now);
                    baseEntity.setModifiedAt(now);
                    repository.save(entity.get());
                }
                return true;
            }
            throw new IllegalArgumentException("Entity with ID: " + id + "is not soft-deletable");
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, null);
    }

    public boolean revertSoftDeleteById(ID id) {
        Optional<E> entity = repository.findById(id);
        if (entity.isPresent()) {
            if (entity.get() instanceof BaseEntity baseEntity){
                if (Objects.nonNull(baseEntity.getDeletedAt())){
                    baseEntity.setDeletedAt(null);
                    baseEntity.setModifiedAt(new Date().getTime());
                    repository.save(entity.get());
                }
                return true;
            }
            throw new IllegalArgumentException("Entity with ID: " + id + "is not soft-deletable");
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, null);
    }

    private E update(E entity, ID id) {
        Optional<E> existingEntity = repository.findById(id);
        if (existingEntity.isPresent()){
            if (entity instanceof BaseEntity baseEntity) {
                baseEntity.setModifiedAt(new Date().getTime());
            }
            try {
                NullAwareBeanUtils.getInstance().copyProperties(existingEntity.get(), entity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            beforeUpdate(entity);
            return repository.save(existingEntity.get());
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, null);

    }

    private E save(E entity) {
        if (entity instanceof BaseEntity baseEntity) {
            long now = new Date().getTime();
            baseEntity.setCreatedAt(now);
            baseEntity.setModifiedAt(now);
        }
        beforeSave(entity);
        return repository.save(entity);
    }

    public void beforeSave(E entity) {
    }
    public void beforeUpdate(E entity) {
    }
    public void beforeDelete(E entity) {
    }


}

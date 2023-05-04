package com.openjob.service;

import com.openjob.model.entity.Specialization;
import com.openjob.repository.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecializationService extends BaseService<Specialization, String> {
    private final SpecializationRepository specializationRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void init() {
        repository = this.specializationRepository;
        baseMongoTemplate = this.mongoTemplate;
        clazz = Specialization.class;
    }
}

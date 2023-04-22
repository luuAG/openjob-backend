package com.openjob.service;

import com.openjob.model.entity.Candidate;
import com.openjob.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateService extends BaseService<Candidate, ObjectId> {
    private final CandidateRepository candidateRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void init() {
        repository = this.candidateRepository;
        baseMongoTemplate = mongoTemplate;
        clazz = Candidate.class;
    }
}

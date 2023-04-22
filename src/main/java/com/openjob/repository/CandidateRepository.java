package com.openjob.repository;

import com.openjob.model.entity.Candidate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository  extends MongoRepository<Candidate, ObjectId> {
}

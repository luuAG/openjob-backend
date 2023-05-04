package com.openjob.repository;

import com.openjob.model.entity.Specialization;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends MongoRepository<Specialization, String> {
}

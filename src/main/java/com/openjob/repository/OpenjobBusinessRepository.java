package com.openjob.repository;

import com.openjob.model.entity.OpenjobBusiness;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenjobBusinessRepository extends MongoRepository<OpenjobBusiness, String> {
}

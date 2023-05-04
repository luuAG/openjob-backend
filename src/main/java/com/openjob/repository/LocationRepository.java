package com.openjob.repository;

import com.openjob.model.entity.Province;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends MongoRepository<Province, String> {
}

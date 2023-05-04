package com.openjob.repository;

import com.openjob.model.entity.base.BaseUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseUserRepository extends MongoRepository<BaseUser, String> {
}

package com.openjob.repository;

import com.openjob.model.entity.Company;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends MongoRepository<Company, ObjectId> {

    Optional<Company> findByCompanyName(String companyName);
}

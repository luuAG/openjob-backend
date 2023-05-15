package com.openjob.repository;

import com.openjob.model.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    void deleteByReferencedUserId(String userId);

    Account findByUsername(String email);
}

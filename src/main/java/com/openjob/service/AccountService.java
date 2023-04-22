package com.openjob.service;

import com.openjob.model.entity.Account;
import com.openjob.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService extends BaseService<Account, ObjectId> {
    private final AccountRepository accountRepository;
    private final MongoTemplate mongoTemplate;
//    private final PasswordEncoder passwordEncoder;

    @Override
    protected void init() {
        repository = accountRepository;
        baseMongoTemplate = mongoTemplate;
    }

    @Override
    public Account saveUpdate(Account entity, ObjectId objectId) {
//        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.saveUpdate(entity, objectId);
    }
}

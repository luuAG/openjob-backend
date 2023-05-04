package com.openjob.service;

import com.openjob.model.entity.Account;
import com.openjob.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService extends BaseService<Account, String> {
    private final AccountRepository accountRepository;
    private final MongoTemplate mongoTemplate;
//    private final PasswordEncoder passwordEncoder;

    @Override
    protected void init() {
        repository = accountRepository;
        baseMongoTemplate = mongoTemplate;
    }

    @Override
    public Account saveUpdate(Account entity, String id) {
//        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return super.saveUpdate(entity, id);
    }

    public void deleteByReferencedUserId(String deletedUserId) {
        accountRepository.deleteByReferencedUserId(deletedUserId);
    }
}

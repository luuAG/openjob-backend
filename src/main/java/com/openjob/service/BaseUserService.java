package com.openjob.service;

import com.openjob.model.entity.Account;
import com.openjob.model.entity.base.BaseUser;
import com.openjob.repository.BaseUserRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseUserService extends BaseService<BaseUser, ObjectId> {
    private final BaseUserRepository baseUserRepository;
    private final MongoTemplate mongoTemplate;
    private final AccountService accountService;

    @Override
    protected void init() {
        repository = this.baseUserRepository;
        baseMongoTemplate = this.mongoTemplate;
        clazz = BaseUser.class;
    }

    public BaseUser create(BaseUser admin, Account account){
        Account savedAccount = accountService.saveUpdate(account, account.getId());
        admin.setAccount(savedAccount);
        return saveUpdate(admin, admin.getId());
    }

    @Override
    public void beforeDelete(BaseUser user) {
        accountService.deleteById(user.getAccount().getId());
    }
}

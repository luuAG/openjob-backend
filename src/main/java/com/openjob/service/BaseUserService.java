package com.openjob.service;

import com.openjob.model.dto.base.BaseUserDTO;
import com.openjob.model.dto.request.NewAdminDTO;
import com.openjob.model.entity.Account;
import com.openjob.model.entity.base.BaseUser;
import com.openjob.model.mapper.AccountMapper;
import com.openjob.model.mapper.BaseUserMapper;
import com.openjob.repository.BaseUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseUserService extends BaseService<BaseUser, String> {
    private final BaseUserRepository baseUserRepository;
    private final MongoTemplate mongoTemplate;
    private final AccountService accountService;

    private final BaseUserMapper baseUserMapper;
    private final AccountMapper accountMapper;

    @Override
    protected void init() {
        repository = this.baseUserRepository;
        baseMongoTemplate = this.mongoTemplate;
        clazz = BaseUser.class;
    }

    public BaseUserDTO createNewAdminAccount(NewAdminDTO dto){
        BaseUser admin = baseUserMapper.toEntity(dto.getAdmin());
        Account account = accountMapper.toEntity(dto.getAccount());
        Account savedAccount = accountService.saveUpdate(account, account.getId());

        admin.setAccount(savedAccount);
        BaseUser savedAdmin;
        try {
            savedAdmin = saveUpdate(admin, admin.getId());
            savedAccount.setReferencedUserId(savedAdmin.getId());
            accountService.saveUpdate(savedAccount, savedAccount.getId());
            return baseUserMapper.toDTO(savedAdmin);
        } catch (Exception e) {
            accountService.deleteById(savedAccount.getId());
            throw e;
        }
    }

}

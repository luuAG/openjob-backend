package com.openjob.service;

import com.openjob.model.entity.Account;
import com.openjob.model.entity.Company;
import com.openjob.model.enums.Role;
import com.openjob.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CompanyService extends BaseService<Company, ObjectId> {
    private final CompanyRepository companyRepository;
    private final MongoTemplate mongoTemplate;
    private final AccountService accountService;

    @Override
    protected void init() {
        repository = this.companyRepository;
        baseMongoTemplate = this.mongoTemplate;
        clazz = Company.class;
    }

    public Company create(Company company, Account account) {
        account.setRole(Role.COMPANY);
        Account savedAccount = accountService.saveUpdate(account, account.getId());
        company.setAccount(savedAccount);
        company.setDeletedAt(new Date().getTime());
        return saveUpdate(company, company.getId());
    }

    @Override
    public void beforeDelete(Company company) {
        accountService.deleteById(company.getAccount().getId());
    }

    @Override
    public void beforeSave(Company entity) {
        if (Objects.isNull(entity.getAccount()))
            entity.setDeletedAt(new Date().getTime());
    }

    public boolean existsByName(String companyName) {
        return companyRepository.findByCompanyName(companyName).isPresent();
    }

    public boolean approveCompanyById(ObjectId id) {
        return revertSoftDeleteById(id);
    }
}

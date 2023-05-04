package com.openjob.service;

import com.openjob.model.dto.request.NewCompanyDTO;
import com.openjob.model.dto.shared.CompanyDTO;
import com.openjob.model.entity.Account;
import com.openjob.model.entity.Company;
import com.openjob.model.enums.Role;
import com.openjob.model.mapper.AccountMapper;
import com.openjob.model.mapper.CompanyMapper;
import com.openjob.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CompanyService extends BaseService<Company, String> {
    private final CompanyRepository companyRepository;
    private final MongoTemplate mongoTemplate;
    private final AccountService accountService;

    private final AccountMapper accountMapper;
    private final CompanyMapper companyMapper;

    @Override
    protected void init() {
        repository = this.companyRepository;
        baseMongoTemplate = this.mongoTemplate;
        clazz = Company.class;
    }

    public CompanyDTO createNewCompanyAccount(NewCompanyDTO newCompanyDTO) {
        Account account = accountMapper.toEntity(newCompanyDTO.getAccount());
        Company company = companyMapper.toEntity(newCompanyDTO.getCompany());
        account.setRole(Role.COMPANY);
        account.setDeletedAt(new Date().getTime()); // deactivated
        Account savedAccount = accountService.saveUpdate(account, account.getId());

        company.setAccount(savedAccount);
        company.setDeletedAt(new Date().getTime()); // deactivated
        Company savedCompany;
        // save company failed -> rollback saved account
        try {
            savedCompany = saveUpdate(company, company.getId());
            savedAccount.setReferencedUserId(savedCompany.getId());
            accountService.saveUpdate(savedAccount, savedAccount.getId());
        }catch (Exception e){
            accountService.deleteById(savedAccount.getId());
            throw e;
        }
        return companyMapper.toDTO(savedCompany);
    }

    public boolean approveCompanyById(String id) {
        Company company = getById(id);
        return accountService.revertSoftDeleteById(company.getAccount().getId())
                && revertSoftDeleteById(id);
    }
}

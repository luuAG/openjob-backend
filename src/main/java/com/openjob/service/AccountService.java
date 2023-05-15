package com.openjob.service;

import com.openjob.constant.ErrorMessage;
import com.openjob.model.dto.enums.EmailCase;
import com.openjob.model.entity.Account;
import com.openjob.repository.AccountRepository;
import com.openjob.util.EmailUtils;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService extends BaseService<Account, String> {
    private final AccountRepository accountRepository;
    private final MongoTemplate mongoTemplate;
    private final EmailUtils emailUtils;
//    private final PasswordEncoder passwordEncoder;

    @Value("${client.base_url}")
    private String clientBaseUrl;

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

    public boolean createForgotPasswordToken(String email) throws MessagingException, TemplateException, IOException {
        Account account = accountRepository.findByUsername(email);
        if (Objects.nonNull(account)){
            String token = UUID.randomUUID().toString();
            account.setForgotPasswordToken(token);
            saveUpdate(account, account.getId());
            Map<String, Object> data = new HashMap<>();
            data.put("resetPasswordURL", clientBaseUrl+"/reset-password/"+token);
            emailUtils.sendEmail(email, "Reset password", data, EmailCase.FORGOT_PASSWORD);
            return true;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessage.ENTITY_NOT_FOUND, null);
    }

    public boolean verifyForgotPasswordToken(String username, String token) {
        Account account = accountRepository.findByUsername(username);
        if (Objects.nonNull(account)){
            return account.getForgotPasswordToken().equals(token);
        }
        return false;
    }

    public boolean resetPassword(String username, String password) {
        Account account = accountRepository.findByUsername(username);
        if (Objects.nonNull(account)){
            account.setPassword(password);
            saveUpdate(account, account.getId());
            return true;
        }
        return false;
    }
}

package com.openjob.eventlistener;

import com.openjob.model.entity.base.BaseUser;
import com.openjob.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeDeleteEvent;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class BaseUserEventListener extends AbstractMongoEventListener<Object> {
    private final AccountService accountService;

    @Override
    public void onBeforeDelete(BeforeDeleteEvent<Object> event) {
        // Delete account when delete an instance of BaseUser: Admin, Company, Candidate
        if (Objects.equals(event.getType(), BaseUser.class) || Objects.requireNonNull(event.getType()).getSuperclass().equals(BaseUser.class)){
            String deletedUserId = event.getSource().getObjectId("_id").toHexString();
            accountService.deleteByReferencedUserId(deletedUserId);
        }

    }
}

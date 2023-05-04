package com.openjob.model.entity.base;

import com.openjob.model.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class BaseUser extends BaseEntity {
    @DBRef
    protected Account account;

    protected String fullName;
    protected String jobRole;
    protected Date dob;
    protected String phone;
    protected List<String> addresses;
    protected String avatarUrl;
}

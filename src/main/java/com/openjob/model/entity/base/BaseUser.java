package com.openjob.model.entity.base;

import com.openjob.model.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
//@EnableMongoAuditing
public class BaseUser extends BaseEntity {
    @DBRef
    protected Account account;

    protected String fullName;
    protected ZonedDateTime dob;
    protected String phone;
    protected List<String> addresses;
    protected String avatarUrl;
    protected String role;

}

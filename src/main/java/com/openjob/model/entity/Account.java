package com.openjob.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.openjob.model.entity.base.BaseEntity;
import com.openjob.model.dto.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {
    @Indexed(unique = true, sparse = true, name = "username-account")
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private Role role;
    @JsonIgnore
    private String referencedUserId;

}

package com.openjob.model.entity;

import com.openjob.model.entity.base.BaseEntity;
import com.openjob.model.enums.Role;
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
    @Indexed(unique = true)
    private String username;
    private String password;
    private Role role;
}

package com.symbo.insurance.microservicetest.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
public class UserDetails {
    @Id
    private String userId;
    private String password;
    private String userStatus;
    @DBRef
    private List<Address> addressList;
}

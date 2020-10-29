package com.symbo.insurance.microservicetest.model;

import lombok.Data;

@Data
public class UserAuthenticationInput {
    private String userId;
    private String password;
}

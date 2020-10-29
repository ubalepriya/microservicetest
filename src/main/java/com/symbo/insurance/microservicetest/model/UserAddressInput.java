package com.symbo.insurance.microservicetest.model;

import com.symbo.insurance.microservicetest.domain.Address;
import lombok.Data;

@Data
public class UserAddressInput {
    private String userId;
    private Address address;
}

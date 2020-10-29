package com.symbo.insurance.microservicetest.model;

import com.symbo.insurance.microservicetest.domain.Address;
import lombok.Data;

import java.util.List;

@Data
public class UserModel {
    private String userId;
    private String userStatus;
    private List<Address> addressList;
}

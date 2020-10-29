package com.symbo.insurance.microservicetest.services;

import com.symbo.insurance.microservicetest.domain.Address;
import com.symbo.insurance.microservicetest.model.UserAddressInput;
import com.symbo.insurance.microservicetest.model.UserModel;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserDetailsService {

    UserModel getUserDetails(String userId ) throws Exception;
    boolean authenticateUser(String userId, String password) throws Exception;
    UserModel saveDeliveryAddress(String userId, Address addressInput) throws Exception;
}

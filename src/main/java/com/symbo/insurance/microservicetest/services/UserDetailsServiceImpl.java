package com.symbo.insurance.microservicetest.services;

import com.symbo.insurance.microservicetest.domain.Address;
import com.symbo.insurance.microservicetest.domain.UserDetails;
import com.symbo.insurance.microservicetest.model.UserModel;
import com.symbo.insurance.microservicetest.repository.AddressRepository;
import com.symbo.insurance.microservicetest.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private AddressRepository addressRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public UserModel getUserDetails(String userId) throws Exception {
        UserModel userModel = null;
        if(userId != null){
            UserDetails userDetails =   null;
            Optional<UserDetails> optionalUser   =   userRepository.findById(userId);
            if(optionalUser.isPresent()){
                userDetails = optionalUser.get();
                userModel = new UserModel();
                userModel.setUserId(userDetails.getUserId());
                userModel.setUserStatus(userDetails.getUserStatus());
                userModel.setAddressList(userDetails.getAddressList());
            }
        }
        return userModel;
    }

    @Override
    public boolean authenticateUser(String userId, String password) throws Exception {
        boolean isUserPresent =   false;
        UserDetails userDetails =   null;
        
        log.info("Authenticating User :: "+ userId +" and password :: "+password);
        
        if(userId != null && password != null){
            Optional<UserDetails> optionalUser   =   userRepository.findById(userId);

            if(optionalUser.isPresent()){

                userDetails = optionalUser.get();
                log.info("User found with password :: " +userDetails.getPassword());
                if(userDetails.getPassword().equals(password))
                {
                    log.info("Password matches");
                    isUserPresent = true;
                }
                else
                {
                    log.info("Password does not matche");
                }
            }
        }
        log.info("isUserPresent :: "+isUserPresent);
        return isUserPresent;
    }

    @Override
    public UserModel saveDeliveryAddress(String userId, Address addressInput) throws Exception {
        UserDetails userDetailsNew = null, userDetailsReturn = null;
        UserModel userModel = null;

        if(userId != null){
            log.info("Check if this user is present.");
            Optional<UserDetails> optionalUser   =   userRepository.findById(userId);

            if(optionalUser.isPresent()){
                userDetailsNew = optionalUser.get();

                log.info("Setting Shipping Address");
                Address address = addressInput;

                if(userDetailsNew.getAddressList() != null){
                    userDetailsNew.getAddressList().add(address);
                }
                else{
                    List<Address> addressList = new ArrayList<>();
                    addressList.add(address);
                    userDetailsNew.setAddressList(addressList);
                }

                log.info("Saving Address");
                addressRepository.save(address);
                log.info("Address saved");

                log.info("Saving User");
                userDetailsReturn = userRepository.save(userDetailsNew);
                log.info("User saved");

                log.info("Creating return object");
                userModel = new UserModel();
                userModel.setUserId(userDetailsReturn.getUserId());
                userModel.setUserStatus(userDetailsReturn.getUserStatus());
                userModel.setAddressList(userDetailsReturn.getAddressList());
            }
        }
        return userModel;
    }
}

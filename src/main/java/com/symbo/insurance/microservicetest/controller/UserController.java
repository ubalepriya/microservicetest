package com.symbo.insurance.microservicetest.controller;

import com.symbo.insurance.microservicetest.model.UserAddressInput;
import com.symbo.insurance.microservicetest.model.UserAuthenticationInput;
import com.symbo.insurance.microservicetest.model.UserModel;
import com.symbo.insurance.microservicetest.services.UserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {

    private UserDetailsService userDetailsService;

    UserController(UserDetailsService userDetailsService){
        this.userDetailsService= userDetailsService;
    };

    @GetMapping("/getUserDetails/userId/{userId}")
    public UserModel getUserDetails(@PathVariable String userId){

        UserModel userModel = null;
        try
        {
            userModel = userDetailsService.getUserDetails(userId);
        }
        catch(Exception ex){
            log.error(ex.getMessage(),ex);
        }

        return userModel;
    }

    //@GetMapping("/authenticateUser/userId/{userId}/password/{password}")
    //public boolean authenticateUser(@PathVariable String userId,@PathVariable String password){
    @PostMapping("/authenticateUser")
    public boolean authenticateUser(@RequestBody UserAuthenticationInput userAuthenticationInput){
        boolean isUserPresent =   false;
        if(userAuthenticationInput != null){
            try{
                isUserPresent = userDetailsService.authenticateUser(userAuthenticationInput.getUserId(), userAuthenticationInput.getPassword());
            }
            catch (Exception ex){
                log.error(ex.getMessage(),ex);
            }

        }
        return isUserPresent;
    }

    @PostMapping("saveDeliveryAddress")
    public UserModel saveDeliveryAddress(@RequestBody UserAddressInput userAddressInput){

        UserModel userModel = null;

        if(userAddressInput != null){
            try{
                userModel = userDetailsService.saveDeliveryAddress(userAddressInput.getUserId(), userAddressInput.getAddress());
            }
            catch (Exception ex){
                log.error(ex.getMessage(),ex);
            }
        }
        return userModel;
    }
}

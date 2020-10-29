package com.symbo.insurance.microservicetest.bootstrapdata;

import com.symbo.insurance.microservicetest.domain.UserDetails;
import com.symbo.insurance.microservicetest.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoadData implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    public LoadData(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        UserDetails userDetails = new UserDetails();
        userDetails.setUserId("1");
        userDetails.setPassword("abc@123");
        userDetails.setUserStatus("A");

        log.info("Saving User Details");
        userRepository.save(userDetails);
        log.info("User Details saved");

    }
}

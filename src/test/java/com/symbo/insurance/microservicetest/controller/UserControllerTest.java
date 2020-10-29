package com.symbo.insurance.microservicetest.controller;

import com.symbo.insurance.microservicetest.model.UserAuthenticationInput;
import com.symbo.insurance.microservicetest.model.UserModel;
import com.symbo.insurance.microservicetest.services.UserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserDetailsService userDetailsService;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void getUserDetails() throws Exception{

        UserModel userModel = new UserModel();
        userModel.setUserId("1");
        userModel.setUserStatus("A");

        String userId = "1";

            when(userDetailsService.getUserDetails(userId)).thenReturn(userModel);
            mockMvc.perform(get("/getUserDetails/userId/"+userId))
                    .andExpect(status().isOk());

        verify(userDetailsService, times(1)).getUserDetails(userId);
    }

}
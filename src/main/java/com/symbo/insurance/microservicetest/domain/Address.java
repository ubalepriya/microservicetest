package com.symbo.insurance.microservicetest.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class Address {
    @Id
    private String id = UUID.randomUUID().toString();
    private AddressType addressType;
    private String pinCode;
    private String addLine1;
    private String addLine2;
    private String city;
    private String state;
    private String country;
}

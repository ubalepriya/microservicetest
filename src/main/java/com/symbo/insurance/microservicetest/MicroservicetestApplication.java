package com.symbo.insurance.microservicetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicetestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicetestApplication.class, args);

    }

}

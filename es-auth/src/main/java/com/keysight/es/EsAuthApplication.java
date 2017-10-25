package com.keysight.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EsAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsAuthApplication.class, args);
    }
}

package com.keysight.es.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EsEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EsEurekaApplication.class, args);
    }
}

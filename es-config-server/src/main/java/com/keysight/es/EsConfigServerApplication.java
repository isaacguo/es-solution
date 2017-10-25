package com.keysight.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EsConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsConfigServerApplication.class, args);
    }
}

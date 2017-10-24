package com.keysight.es.tool.support.obfuscation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.keysight.es"})
@EntityScan("com.keysight.es")
@EnableConfigurationProperties
public class EsToolSupportObfuscationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsToolSupportObfuscationApplication.class, args);
    }
}

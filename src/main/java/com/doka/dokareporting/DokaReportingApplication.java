package com.doka.dokareporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.doka")
@SpringBootApplication
public class DokaReportingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DokaReportingApplication.class, args);
    }

}

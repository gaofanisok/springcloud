package com.providertwos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages={"com.providertwos"})
public class ProvidertwosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvidertwosApplication.class, args);
    }

}

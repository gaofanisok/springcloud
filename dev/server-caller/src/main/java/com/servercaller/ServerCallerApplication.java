package com.servercaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient//允许注册到注册中心
@EnableFeignClients//允许服务调用
@SpringBootApplication
public class ServerCallerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerCallerApplication.class, args);
    }

}

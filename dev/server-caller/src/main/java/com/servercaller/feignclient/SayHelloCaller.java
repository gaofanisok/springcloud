package com.servercaller.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: gaofan
 * @Date: 2020/4/13 0013 14 30
 * @Description:调用service-provider的SayHello类的方法
 */
@FeignClient(value = "server-provider")
public interface SayHelloCaller {
    @RequestMapping("/hello")
    public String sayHello();

}

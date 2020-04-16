package com.serverprovider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: gaofan
 * @Date: 2020/4/13 0013 14 27
 * @Description:服务提供者提供打招呼的服务
 */
@Controller
public class SayHello {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello!8082";
    }
}

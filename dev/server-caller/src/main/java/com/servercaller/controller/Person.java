package com.servercaller.controller;

import com.servercaller.feignclient.SayHelloCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Administrator
 * @Date: 2020/4/13 0013 14 33
 * @Description:
 */
@Controller
public class Person {
    @Autowired
    private SayHelloCaller caller;
    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return caller.sayHello();
    }
}


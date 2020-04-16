package com.providertwos.controller;

import com.alibaba.fastjson.JSONObject;
import com.providertwos.service.IUserService;
import com.providertwos.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.UnsupportedEncodingException;

/**
 * @Auther: Administrator
 * @Date: 2020/4/15 0015 15 29
 * @Description:
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    IUserService userService;
    /**
     *<pre>
     * Description  : 登陆  <br/>
     * ChangeLog    : 1. 创建 (2020/4/15 0015 15:29 [gaofan]);
     * @author gaofan
     * @date 2020/4/15 0015 15:29
     *</pre>
    */
    @RequestMapping(value = "/UserLogin",method = RequestMethod.POST)
    public String login(@RequestParam String name,@RequestParam int id){
        boolean isSuccess=userService.getUserIsok(name,id);
        if (isSuccess){
            try {
                String token=Util.sign(name,id);
                if (token!=null){
                    return token;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "登陆失败";
    }
}

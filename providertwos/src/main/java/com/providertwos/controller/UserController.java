package com.providertwos.controller;

import com.providertwos.entity.User;
import com.providertwos.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/4/13 0013 16 40
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("/userList")
    public List getUserList( HttpServletRequest request){
        int pageIndex =Integer.valueOf(request.getParameter("pageIndex")) ;
        int pageSize =Integer.valueOf(request.getParameter("pageSize")) ;
        String name =request.getParameter("name") ;

        List<User> userList=iUserService.findAllUser(pageIndex,pageSize,name);
        return userList;
    }
    @RequestMapping("/GetUser")
    public String getUserById(@RequestParam int id){
        return iUserService.getUserById(id);
    }
    @RequestMapping("/add")
    public String addUser(@RequestBody User user){
        if(user!=null){

            iUserService.createUser(user);
            return "success";
        }else{
            return "error";
        }
    }
//    @RequestMapping("/delUser")
//    public String delUser(@RequestParam int id){
//        try {
//            iUserService.delUser(id);
//            return "del success";
//        }catch (Exception e ){
//            e.printStackTrace();
//            return "del false";
//        }
//    }
//    @RequestMapping("/updateUser")
//    public String updateUser(@RequestParam int id,@RequestParam String username) {
//        try {
//            iUserService.updateUser(id, username);
//            return "update success";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "update false";
//
//        }
//    }


}

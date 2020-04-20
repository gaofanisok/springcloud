package com.providertwos.controller;

import com.github.pagehelper.PageHelper;
import com.providertwos.entity.User;
import com.providertwos.manager.UserManager;
import com.providertwos.service.IUserService;
import com.providertwos.util.CommonUtil;
import com.providertwos.util.RequestUtil;
import com.providertwos.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2020/4/13 0013 16 40
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static Log logger = LogFactory.getLog(UserController.class);
    @Autowired
    private IUserService iUserService;
    @Resource
    UserManager userManager;
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
    @RequestMapping("/findUserInid")
    public String findUserInid(){
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        return iUserService.findUserInid();
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
        @RequestMapping(value = "showUser", method = RequestMethod.POST)
    public Object selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            int pageIndex=RequestUtil.getInt(request,"pageIndex",1);
            int pageSize=RequestUtil.getInt(request,"pageSize",5);
            String user=userManager.seleuser(pageIndex,pageSize);
            if (StringUtil.isNotEmpty(user)) {
                return  CommonUtil.toReturnJsonMsg(0, "成功",user);
            } else {
                return CommonUtil.toReturnJsonMsg(1, "数据错误：获取数据失败！");
            }
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
        }
        return CommonUtil.toReturnJsonMsg(-1, "系统繁忙，请重试");

    }


}

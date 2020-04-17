package com.providertwos.service.impl;

import com.providertwos.dao.UserDao;
import com.providertwos.entity.User;
import com.providertwos.redis.RedisDao;
import com.providertwos.service.IUserService;
import com.providertwos.util.Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: Administrator
 * @Date: 2020/4/13 0013 16 41
 * @Description:
 */
@Service("IUserService")
@Component
public class UserService implements IUserService {
    @Autowired
    public UserDao userDao;
    @Autowired
    public RedisDao redisDao;

    @Override
    public void createUser(User user){
        redisDao.setKey("name",user.getName());
        redisDao.setKey("birthday",user.getBirthday().toString());
        redisDao.setKey("address",user.getAddress());
        // user.setId(3);
//        System.out.println(redisDao.getValue("birthday"));
        user.setId(Integer.parseInt(UUID.randomUUID().toString()));
        userDao.createUser(user);
    }
    @Override
    public List<User> findAllUser(int pageIndex,int pageSize,String name) {

        if (pageIndex>0 && pageSize>0){
            pageIndex=(pageIndex-1)*pageSize;
            return userDao.findAllUser(pageIndex,pageSize,name);
        }else {
            return null;
        }

    }
//    @Override
//    public void delUser(int id) {
//        userDao.delUser(id);
//    }
//    @Override
//    public void updateUser(int id, String username) {
//        userDao.updateUser(id,username);
//    }

    @Override
    public String getUserById(int id) {
        List<Integer> useridList=new ArrayList<>();
        JSONObject jb=new JSONObject();
        useridList.add(1);
        useridList.add(2);
        useridList.add(3);
        JSONArray ja=new JSONArray();
        for (int i=0;i<useridList.size();i++){
            Map<String,Object> map=new HashMap<>();
            User user=userDao.getUserById(useridList.get(i));
            map.put("id",user.getId());
            map.put("name",user.getName());
            map.put("birthday",Util.dateToString(user.getBirthday(),"yyyy-MM-dd HH:mm:ss"));
            map.put("address",user.getAddress());
            ja.add(map);
        }
        jb.put("data",ja);
        return jb.toString();
    }

    @Override
    public Boolean getUserIsok(String name, int id) {
        List<User> userList=userDao.getUserIsok(name,id);
        if (userList.size()>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String findUserInid() {

        JSONObject jb=new JSONObject();
        List<Integer> list =new ArrayList<>();
        JSONArray ja=new JSONArray();

        list.add(1);
        list.add(2);
        List<User> userList=userDao.findUserInid(list);
        if (userList.size()>0){
            for (int i=0;i<userList.size();i++){
                Map<String,Object> map=new HashMap<>();
                User user=userList.get(i);
                map.put("id",user.getId());
                map.put("name",user.getName());
                map.put("birthday",Util.dateToString(user.getBirthday(),"yyyy-MM-dd HH:mm:ss"));
                map.put("address",user.getAddress());
                ja.add(map);
            }
            jb.put("data",ja);
        }
        return jb.toString();
    }
}

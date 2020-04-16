package com.providertwos.service;

import com.providertwos.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    /**
     * 新增用户
     * @param user
     */
    public void createUser(User user);
    /**
     * 查询用户列表
     * @return
     */
    public List<User> findAllUser(int pageIndex,int pageSize,String name);
//    /**
//     * 删除用户
//     * @return
//     */
//    void delUser(int id);
//    /**
//     * 修改用户
//     * @return
//     */
//    void updateUser(int id, String username);
    /**
     * 查询单个用户
     * @return
     */
    public String getUserById(int id);

    public Boolean getUserIsok(String name,int id);
}

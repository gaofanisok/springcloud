package com.providertwos.dao;

import com.providertwos.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    /**
     * 新增用户
     * @param user
     */
    @Insert("insert into user VALUES (#{id},#{name},#{birthday},#{address})")
    void createUser(User user);
    /**
     * 查询用户列表
     * @return
     */
   // @Select("select * from user limit #{pageIndex},#{pageSize}")
    List<User> findAllUser(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("name") String name);
//    /**
//     * 删除用户
//     * @return
//     */
//    void delUser(int id);
//    /**
//     *  修改用户
//     *  @return
//     */
//    void updateUser(int id, String username);
    /**
     * 查询单个用户
     *  @return
     */
   // @Select("select * from user where id=#{id}")
    User getUserById(@Param("id")int id);
    /**
     * 查询单个用户是否纯在
     *  @return
     */
   @Select("select * from user where name=#{name} and id=#{id}")
    List<User> getUserIsok(@Param("name")String name,@Param("id")int id);
}

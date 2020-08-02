package com.gyb.dao;

import com.gyb.ssm.domain.Role;
import com.gyb.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/31 10:49
 * @Version 1.0
 * description:
 */

public interface UserDao {
    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/31 10:56
     *
     * @param userName
     * @return
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userName", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.gyb.dao.RoleDao.findRoleByUserId")),


    })
    UserInfo findByUserName(String userName);

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/31 13:22
     *
     * @param
     * @return
     */
    @Select("select * from users")
    List<UserInfo> findAll();

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/31 16:39
     *
     * @param userInfo
     * @return
     */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{userName},#{password},#{phoneNum},#{status})")
    void addUser(UserInfo userInfo);


    /**
     * create by: gb
     * description: TODO
     * create time: 2020/8/1 10:43
     *
     * @param id
     * @return
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userName", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.gyb.dao.RoleDao.findRoleByUserId")),
    })
    UserInfo findById(String id);

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/8/2 13:40
     *
     * @param id
     * @return
     */
    @Select("select * from role where id not in (select roleId from users_role where userId=#{id})")
    List<Role> findOtherRoleByUserId(String id);

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/8/2 14:51
     *
     * @param roleId
     * @param userId
     * @return
     */
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}

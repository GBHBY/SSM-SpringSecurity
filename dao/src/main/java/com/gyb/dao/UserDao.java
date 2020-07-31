package com.gyb.dao;

import com.gyb.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
            @Result(property = "roles", column = "id",javaType = java.util.List.class,many = @Many(select = "com.gyb.dao.RoleDao.findRoleByUserId")),



    })
    UserInfo findByUserName(String userName);

}

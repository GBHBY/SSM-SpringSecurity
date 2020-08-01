package com.gyb.dao;

import com.gyb.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/31 12:02
 * @Version 1.0
 * description:
 */

public interface RoleDao {
    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/31 12:03
     *
     * @param userId
     * @return
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId} )")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.gyb.dao.PermissionDao.findPermissionByRoleID"))

    })
    List<Role> findRoleByUserId(String userId);

    /**
     * create by: gb
     * description: 查询所有
     * create time: 2020/8/1 21:44
     *
     * @param
     * @return
     */
    @Select("select * from role")
    List<Role> findAll();

    /**
     * create by: gb
     * description: 添加用户
     * create time: 2020/8/1 22:00
     *
     * @param role
     * @return
     */
    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
}

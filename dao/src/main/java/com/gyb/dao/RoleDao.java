package com.gyb.dao;

import com.gyb.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

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
    List<Role> findRoleByUserId(String userId);
}

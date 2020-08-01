package com.gyb.dao;

import com.gyb.ssm.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/8/1 12:33
 * @Version 1.0
 * description:
 */

public interface PermissionDao {
    /**
     * create by: gb
     * description: TODO
     * create time: 2020/8/1 12:39
     * @param roleId
     * @return
     */
    @Select("select * from permission where id in (select permissionId from role_permission where id = #{roleId})")
    List<Permission> findPermissionByRoleID(String roleId);
}

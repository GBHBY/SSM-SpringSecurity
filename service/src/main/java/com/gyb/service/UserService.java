package com.gyb.service;

import com.gyb.ssm.domain.Role;
import com.gyb.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/31 10:12
 * @Version 1.0
 * description:
 */

public interface UserService extends UserDetailsService {

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/31 13:21
     *
     * @param
     * @return
     */
    List<UserInfo> findAll();

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/8/1 10:44
     *
     * @param userInfo
     * @return
     */
    void addUser(UserInfo userInfo);


    /**
     * create by: gb
     * description: 添加用户
     * create time: 2020/8/1 10:44
     *
     * @param id
     * @return
     */
    UserInfo findById(String id);

    /**
     * create by: gb
     * description: 查询可以添加的角色
     * create time: 2020/8/2 13:39
     *
     * @param id
     * @return
     */
    List<Role> findOtherRoleByUserId(String id);

    /**
     * create by: gb
     * description: 添加用户角色到user_role表
     * create time: 2020/8/2 14:50
     *
     * @param roleId
     * @param userId
     * @return
     */
    void addRoleToUser(String userId, String roleId);
}

package com.gyb.service;

import com.gyb.ssm.domain.Role;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/8/1 21:42
 * @Version 1.0
 * description:
 */

public interface RoleService {
    /**
     * create by: gb
     * description: TODO
     * create time: 2020/8/1 21:43
     *
     * @param
     * @return
     */
    List<Role> findAll();

    /**
     * create by: gb
     * description: 添加角色
     * create time: 2020/8/1 22:00
     *
     * @param role
     * @return
     */
    void save(Role role);
}

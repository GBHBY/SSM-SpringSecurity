package com.gyb.service;

import com.gyb.ssm.domain.Permission;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/8/2 10:22
 * @Version 1.0
 * description:
 */

public interface PermissionService {

    /**
     * create by: gb
     * description: 查询所有
     * create time: 2020/8/2 10:22
     *
     * @param
     * @return
     */
    List<Permission> findAll();

    /**
     * create by: gb
     * description: 保存
     * create time: 2020/8/2 11:07
     *
     * @param permission
     * @return
     */
    void save(Permission permission);
}

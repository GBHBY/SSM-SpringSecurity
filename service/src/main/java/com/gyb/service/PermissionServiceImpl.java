package com.gyb.service;

import com.gyb.dao.PermissionDao;
import com.gyb.ssm.domain.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/8/2 10:23
 * @Version 1.0
 * description:
 */
@Service
public class PermissionServiceImpl implements  PermissionService {
    @Resource
    private  PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}

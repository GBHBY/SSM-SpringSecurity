package com.gyb.service;

import com.gyb.dao.RoleDao;
import com.gyb.ssm.domain.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/8/1 21:43
 * @Version 1.0
 * description:
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource(name = "roleDao")
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}

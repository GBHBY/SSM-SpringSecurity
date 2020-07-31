package com.gyb.service;

import com.gyb.dao.UserDao;
import com.gyb.ssm.domain.Role;
import com.gyb.ssm.domain.UserInfo;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/31 10:12
 * @Version 1.0
 * description:
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource(name = "passwordEncoder")
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private UserDao userDao;

    /**
     * create by: gb
     * description: 实现UserDetailsService中的方法
     * create time: 2020/7/31 10:14
     *
     * @param userName
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUserName(userName);
        /** 处理自己的用户成为UserDetails */
        User user = new User(userInfo.getUserName(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));

        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        /**对密码进行加密 */
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.addUser(userInfo);
    }
}

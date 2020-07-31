package com.gyb.service;

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

}

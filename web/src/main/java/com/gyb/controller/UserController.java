package com.gyb.controller;

import com.gyb.service.UserService;

import com.gyb.ssm.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/31 13:16
 * @Version 1.0
 * description:
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/7/31 13:18
     *
     * @param
     * @return
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfoList = userService.findAll();
        for(UserInfo userInfo:userInfoList){
            System.out.println(userInfo);
        }
        modelAndView.addObject("userList",userInfoList);
        modelAndView.setViewName("user-list");
        return modelAndView;

    }
}

package com.gyb.controller;

import com.gyb.service.UserService;

import com.gyb.ssm.domain.Role;
import com.gyb.ssm.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
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
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
        modelAndView.addObject("userList", userInfoList);
        modelAndView.setViewName("user-list");
        return modelAndView;

    }

    @RequestMapping("save.do")
    public String userAdd(UserInfo userInfo) {
        if (userInfo.getStatusStr() == "未开启") {
            userInfo.setStatus(0);
        } else if (userInfo.getStatusStr() == "开启") {
            userInfo.setStatus(1);
        } else {
            userInfo.setStatus(3);
        }
        userService.addUser(userInfo);
        return "redirect:findAll.do";
    }

    /**
     * create by: gb
     * description: 用户详情
     * create time: 2020/8/1 10:42
     *
     * @param id
     * @return
     */

    @RequestMapping("findById.do")
    public ModelAndView findById(String id) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show1");
        return modelAndView;
    }

    /**
     * create by: gb
     * description: 查询可以添加的角色
     * create time: 2020/8/2 13:35
     *
     * @param
     * @return
     */
    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        List<Role> otherRoles = userService.findOtherRoleByUserId(id);
        modelAndView.addObject("user", userInfo);
        modelAndView.addObject("otherRoles", otherRoles);
        modelAndView.setViewName("user-role-add");
        return modelAndView;

    }

    /**
     * create by: gb
     * description: 把新添加的角色添加到users_role表中
     * create time: 2020/8/2 14:30
     *
     * @param
     * @return
     */
    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(value = "userId") String userId, @RequestParam(value = "ids") String roleId) {
        userService.addRoleToUser(userId, roleId);
        return "redirect:findAll.do";
    }


}

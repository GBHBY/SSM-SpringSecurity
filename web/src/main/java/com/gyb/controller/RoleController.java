package com.gyb.controller;

import com.gyb.service.RoleService;
import com.gyb.ssm.domain.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/8/1 21:38
 * @Version 1.0
 * description:角色
 */
@Controller
@RequestMapping("role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/8/1 22:03
     *
     * @param role
     * @return
     */
    @RequestMapping("save.do")
    public String saveRole(Role role) {
        roleService.save(role);
        return "redirect:findAll.do";
    }
}

package com.gyb.controller;

import com.gyb.service.PermissionService;
import com.gyb.ssm.domain.Permission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/8/2 10:19
 * @Version 1.0
 * description:
 */
@Controller
@RequestMapping("permission")
public class PermissionController {
    @Resource(name = "permissionServiceImpl")
    private PermissionService permissionService;

    /**
     * create by: gb
     * description: 查询所有资源权限
     * create time: 2020/8/2 10:20
     *
     * @param
     * @return
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    /**
     * create by: gb
     * description: TODO
     * create time: 2020/8/2 11:02
     *
     * @param permission
     * @return
     */
    @RequestMapping("save.do")
    public String save(Permission permission) {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }

}

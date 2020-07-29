package com.gyb.controller;

import com.gyb.service.OrdersService;
import com.gyb.ssm.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/28 21:21
 * @Version 1.0
 * description:
 */
@Controller
@RequestMapping("orders")
public class OrdersController {
    @Resource
    private OrdersService ordersService;

    /**
     * create by: gb
     * description: 查询所有
     * create time: 2020/7/28 21:46
     *
     * @param
     * @return
     */
    @RequestMapping("findAll.do")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> orderList = ordersService.findAll();
        modelAndView.addObject("ordersList", orderList);
        modelAndView.setViewName("orders-list");


        return modelAndView;

    }


}

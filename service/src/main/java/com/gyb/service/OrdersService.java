package com.gyb.service;

import com.gyb.ssm.domain.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/28 21:21
 * @Version 1.0
 * description:
 */

public interface OrdersService {
    /**
     * create by: gb
     * description: 查询订单
     * create time: 2020/7/28 21:22
     *
     * @return
     */
    List<Orders> findAll();
}

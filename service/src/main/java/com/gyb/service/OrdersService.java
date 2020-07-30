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
     * @param page 查询第几页
     * @param size 多少条
     * @return
     */
    List<Orders> findAll(int page,int size);

    /**
     * create by: gb
     * description: 通过id查询订单
     * create time: 2020/7/29 21:32
     * @param orderId
     * @return
     */
    Orders findById(String orderId);
}

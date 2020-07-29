package com.gyb.service;

import com.gyb.dao.OrdersDao;
import com.gyb.ssm.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/28 21:23
 * @Version 1.0
 * description:
 */
@Service
@Transactional
public class OrderServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }
}

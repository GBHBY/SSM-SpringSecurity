package com.gyb.service;

import com.github.pagehelper.PageHelper;
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
    public List<Orders> findAll(int page,int size) {
//        pageNum是页码值，pageSize是每页的条数，要写在查询之前
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }
}

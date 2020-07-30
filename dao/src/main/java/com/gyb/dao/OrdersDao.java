package com.gyb.dao;

import com.gyb.ssm.domain.Member;
import com.gyb.ssm.domain.Orders;
import com.gyb.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/28 21:23
 * @Version 1.0
 * description:
 */

public interface OrdersDao {
    /**
     * create by: gb
     * description: 查询所有
     * create time: 2020/7/28 21:24
     *
     * @return
     */
    @Select("select * from orders")
    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "orderNum", column = "orderNum"),
//            @Result(property = "orderTime", column = "orderTime"),
//            @Result(property = "peopleCount", column = "peopleCount"),
//            @Result(property = "orderDesc", column = "orderDesc"),
//            @Result(property = "payType", column = "payType"),
//            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.gyb.dao.ProductDao.findById"))
    })
    List<Orders> findAll();

    /**
     * create by: gb
     * description: 设计多表操作
     * create time: 2020/7/29 21:33
     *
     * @param orderId
     * @return
     */
    @Select("select * from orders where id =#{orderId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.gyb.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.gyb.dao.MemberDao.findById")),
            @Result(property = "travellerList",column = "id",javaType = java.util.List.class,many = @Many(select="com.gyb.dao.TravellerDao.findByOrdersId"))
    })
    Orders findById(String orderId);
}

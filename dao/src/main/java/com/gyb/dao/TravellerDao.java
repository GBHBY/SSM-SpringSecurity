package com.gyb.dao;

import com.gyb.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/29 22:06
 * @Version 1.0
 * description:
 */

public interface TravellerDao {
    /**
     * create by: gb
     * description: 通过orderId查询
     * create time: 2020/7/29 22:07
     *
     * @param ordersId
     * @return
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId);
}

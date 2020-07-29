package com.gyb.dao;

import com.gyb.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/27 11:05
 * @Version 1.0
 * description:
 */
public interface ProductDao {
    /**
     * create by: gb
     * description: 根据ID查询
     * create time: 2020/7/29 10:36
     *
     * @param id
     * @return
     */
    @Select("select * from product where id =#{id}")
    Product findById(String id);


    /**
     * create by: gb
     * description: 查询所有
     * create time: 2020/7/27 11:06
     *
     * @param
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();

    /**
     * create by: gb
     * description: 保存
     * create time: 2020/7/28 15:52
     *
     * @param product
     * @return
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}

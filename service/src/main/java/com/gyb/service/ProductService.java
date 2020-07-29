package com.gyb.service;

import com.gyb.ssm.domain.Product;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/27 11:07
 * @Version 1.0
 * description:
 */

public interface ProductService {
    /**
     * create by: gb
     * description: 查询所有
     * create time: 2020/7/27 11:07
     *
     * @param
     * @return
     */
    List<Product> findAll();

    /**
     * create by: gb
     * description: 保存商品
     * create time: 2020/7/28 15:51
     *
     * @param product
     * @return
     */
    void save(Product product);
}

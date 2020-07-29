package com.gyb.controller;

import com.gyb.service.ProductService;
import com.gyb.ssm.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/27 13:24
 * @Version 1.0
 * description:
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * create by: gb
     * description: 查询全部产品
     * create time: 2020/7/28 14:52
     *
     * @param
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        modelAndView.addObject("productList", products);
        modelAndView.setViewName("all-admin-datalist");
        return modelAndView;

    }

    /**
     * create by: gb
     * description: 添加产品
     * create time: 2020/7/28 14:53
     *
     * @param product 要添加的产品
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Product product) {
        productService.save(product);
        return "redirect:findAll.do";
    }

}

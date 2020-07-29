package com.gyb.ssm.domain;

import com.gyb.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author gb
 * @Date 2020/7/27 9:34
 * @Version 1.0
 * description:产品信息
 */

public class Product {
    public Product() {

    }

    /**
     * create by: gb
     * description: 主键
     * create time: 2020/7/27 9:40
     */
    private String id;
    /**
     * create by: gb
     * description: 产品名称
     * create time: 2020/7/27 9:40
     */
    private String productName;
    /**
     * create by: gb
     * description: 编号
     * create time: 2020/7/27 9:40
     */
    private String productNum;
    /**
     * create by: gb
     * description: 出发城市
     * create time: 2020/7/27 9:41
     */
    private String cityName;
    /**
     * create by: gb
     * description: 出发时间
     * create time: 2020/7/27 9:41
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    /**
     * create by: gb
     * description: 出发时间格式化
     * create time: 2020/7/27 9:44
     */
    private String departureTimeStr;
    /**
     * create by: gb
     * description: 产品价格
     * create time: 2020/7/27 9:41
     */
    private double productPrice;
    /**
     * create by: gb
     * description: 产品描述
     * create time: 2020/7/27 9:42
     */
    private String productDesc;
    /**
     * create by: gb
     * description: 产品状态
     * create time: 2020/7/27 9:42
     */
    private Integer productStatus;
    /**
     * create by: gb
     * description: 状态格式化
     * create time: 2020/7/27 9:44
     */
    private String productStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (departureTime != null) {
            departureTimeStr = DateUtils.dateToString(departureTime,"yyyy-MM-dd HH:mm:ss");


        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus != null) {
            if (productStatus == 1) {
                productStatusStr = "开启";
            } else {
                productStatusStr = "关闭";
            }


        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}

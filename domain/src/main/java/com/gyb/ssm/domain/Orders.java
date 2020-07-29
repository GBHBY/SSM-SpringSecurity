package com.gyb.ssm.domain;

import com.gyb.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/28 21:06
 * @Version 1.0
 * description:订单
 */

public class Orders {
    public Orders() {

    }

    /**
     * create by: gb
     * description: 主键
     * create time: 2020/7/28 21:09
     */
    private String id;
    /**
     * create by: gb
     * description: 订单编号
     * create time: 2020/7/28 21:10
     */
    private String orderNum;
    /**
     * create by: gb
     * description: 下单时间
     * create time: 2020/7/28 21:10
     */
    private Date orderTime;
    /**
     * create by: gb
     * description: 格式转换
     * create time: 2020/7/28 21:10
     */
    private String orderTimeStr;
    /**
     * create by: gb
     * description: 订单状态 ： 0未支付，1已支付
     * create time: 2020/7/28 21:10
     */
    private int orderStatus;
    /**
     * create by: gb
     * description: 状态格式化
     * create time: 2020/7/29 13:02
     */
    private String orderStatusStr;


    /**
     * create by: gb
     * description: 出行人数
     * create time: 2020/7/28 21:11
     */
    private int peopleCount;

    private Product product;
    private List<Traveller> travellerList;
    private Member member;
    /**
     * create by: gb
     * description: 支付方式 0：支付宝 1：微信 2：其他
     * create time: 2020/7/28 21:14
     */
    private Integer payType;
    /**
     * create by: gb
     * description: 支付格式化
     * create time: 2020/7/28 21:13
     */
    private String payTypeStr;
    /**
     * create by: gb
     * description: 订单描述
     * create time: 2020/7/28 21:13
     */
    private String orderDesc;

    public String getOrderStatusStr() {
        if (orderStatus == 0) {
            orderStatusStr = "未支付";
        } else if (orderStatus == 1) {
            orderStatusStr = "已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if (orderTime != null) {
            orderTimeStr = DateUtils.dateToString(orderTime, "yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellerList() {
        return travellerList;
    }

    public void setTravellerList(List<Traveller> travellerList) {
        this.travellerList = travellerList;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if (payType == 0) {
            payTypeStr = "支付宝";
        } else if (payType == 1) {
            payTypeStr = "微信";
        } else {
            payTypeStr = "其他";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}

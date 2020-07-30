package com.gyb.ssm.domain;

/**
 * @Author gb
 * @Date 2020/7/28 21:06
 * @Version 1.0
 * description:旅客
 */

public class Traveller {

    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    /**
     * 0身份证 1护照 2军官证
     */
    private Integer credentialsType;
    /**
     * 类型转换
     */
    private String credentialsTypeStr;
    private String credentialsNum;
    /**
     * 旅客类型 0承认 1儿童
     */
    private Integer travellerType;
    private String travellerTypeStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {

        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        if (credentialsType == 0) {
            credentialsTypeStr = "身份证";
        } else if (credentialsType == 1) {
            credentialsTypeStr = "护照";
        } else {
            credentialsTypeStr = "军官证";
        }

        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        if (travellerType == 0) {
            travellerTypeStr = "成人";
        } else {
            travellerTypeStr = "儿童";
        }

        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}

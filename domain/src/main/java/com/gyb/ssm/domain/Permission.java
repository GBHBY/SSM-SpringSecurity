package com.gyb.ssm.domain;

import java.util.List;

/**
 * @Author gb
 * @Date 2020/7/31 10:50
 * @Version 1.0
 * description:
 */

public class Permission {

    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

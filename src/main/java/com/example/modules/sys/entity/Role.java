package com.example.modules.sys.entity;

import java.util.List;

public class Role {

    // 角色 code
    private String code;
    // 角色名
    private String name;

    private List<Permission> permissionList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}

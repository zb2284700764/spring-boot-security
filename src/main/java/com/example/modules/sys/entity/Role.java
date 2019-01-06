package com.example.modules.sys.entity;

import java.util.List;

public class Role {

    // 角色 code
    private String code;
    // 角色名
    private String name;

    private List<Permission> permissionList;

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}

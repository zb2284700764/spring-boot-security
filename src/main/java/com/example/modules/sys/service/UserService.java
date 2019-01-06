package com.example.modules.sys.service;

import com.example.modules.sys.entity.Permission;
import com.example.modules.sys.entity.Role;
import com.example.modules.sys.entity.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class UserService {


    public User getUserByusername(String username) {

        Permission p1 = new Permission();
        p1.setCode("UserIndex");
        p1.setName("个人中心");
        p1.setUrl("/user/index.html");

        Permission p2 = new Permission();
        p2.setCode("BookList");
        p2.setName("图书列表");
        p2.setUrl("/book/list");

        Permission p3 = new Permission();
        p3.setCode("BookAdd");
        p3.setName("添加图书");
        p3.setUrl("/book/add");

        Permission p4 = new Permission();
        p4.setCode("BookDetail");
        p4.setName("查看图书");
        p4.setUrl("/book/detail");

        Role admin = new Role();
        admin.setPermissionList(Arrays.asList(p1, p2, p3, p4));

        Role developer = new Role();
        developer.setPermissionList(Arrays.asList(p1, p2));


        User user = new User();
        if ("admin".equals(username)) {
            user.setRoleList(Arrays.asList(admin, developer));
        } else {
            user.setRoleList(Collections.singletonList(developer));
        }

        return user;
    }

}

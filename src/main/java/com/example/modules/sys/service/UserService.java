package com.example.modules.sys.service;

import com.example.common.service.CrudService;
import com.example.modules.sys.dao.UserDao;
import com.example.modules.sys.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends CrudService<UserDao, User> {


    /**
     * 根据登录名获取用户信息
     *
     */
    public User getUserByUsername(String username) {

        return dao.getUserByUsername(username);
    }

    /**
     * 查询所有用户
     *
     */
    public List<User> findAllUser() {

        List<User> userList = dao.findAllUser();
        return userList;
    }

}

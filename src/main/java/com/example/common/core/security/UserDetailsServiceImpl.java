package com.example.common.core.security;

import com.example.modules.sys.entity.User;
import com.example.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用于加载特定用户信息的，它只有一个接口通过指定的用户名去查询用户
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    /**
     * 通过用户名查询用户
     * @param username 登录名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByusername(username);
        if (null == user) {
            throw new UsernameNotFoundException(username);
        }


        return user;
    }



}

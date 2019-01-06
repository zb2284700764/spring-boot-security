package com.example.common.core.security;

import com.example.modules.sys.entity.Permission;
import com.example.modules.sys.entity.Role;
import com.example.modules.sys.entity.User;
import com.example.modules.sys.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

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

        List<SimpleGrantedAuthority> authorities = Lists.newArrayList();
        for (Role role : user.getRoleList()) {
            for (Permission permission : role.getPermissionList()) {
                authorities.add(new SimpleGrantedAuthority(permission.getCode()));
            }
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }



}

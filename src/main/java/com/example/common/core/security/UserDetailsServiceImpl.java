package com.example.common.core.security;

import com.example.modules.sys.entity.Menu;
import com.example.modules.sys.entity.Role;
import com.example.modules.sys.entity.User;
import com.example.modules.sys.service.MenuService;
import com.example.modules.sys.service.RoleService;
import com.example.modules.sys.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用于加载特定用户信息的，它只有一个接口通过指定的用户名去查询用户
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;


    /**
     * 通过用户名查询用户
     * @param username 登录名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException(username);
        }

        // 角色、权限集合
        List<SimpleGrantedAuthority> authorities = Lists.newArrayList();

        // 角色
        List<Role> roleList = roleService.findRoleByUserId(user.getId());
        for (Role role : roleList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleType()));
        }

        List<Menu> menuList = menuService.findMenuByUserId(user.getId());
        // 菜单
        for (Menu menu: menuList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + menu.getPermission()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

}

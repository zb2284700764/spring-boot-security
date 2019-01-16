package com.example.modules.sys.service;

import com.example.common.service.CrudService;
import com.example.common.util.JsonMapper;
import com.example.modules.sys.dao.MenuDao;
import com.example.modules.sys.entity.Menu;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuService extends CrudService<MenuDao, Menu> {

    /**
     * 根据 userId 查询该用户对应的菜单(权限)
     *
     * @param userId
     * @return
     */
    public List<Menu> findMenuByUserId(String userId) {

        List<Menu> menus = dao.findMenuByUserId(userId);

        // key 是父菜单的ID，value 是父菜单对象，父菜单下中的 childMenus 存储的事该父菜单下的儿子菜单，孙子菜单不管
        Map<String, Menu> maps = Maps.newLinkedHashMap();
        for (Menu menu : menus) {
            Menu parentMenu = maps.get((menu.getParentId()));
            if (parentMenu == null) {
                parentMenu = new Menu();
            }
            parentMenu.getChildMenus().add(menu);
            maps.put(menu.getParentId(), parentMenu);
            maps.put(menu.getId(), menu);
        }

        // 根据 maps 将 menus 组装成树形结构，0 为根菜单，是个空菜单
        Menu rootMenu = maps.get("0");
        menus = rootMenu.getChildMenus();
        System.out.println(JsonMapper.toJsonString(rootMenu));


        return menus;
    }


}

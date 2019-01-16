package com.example.modules.sys.service;

import com.example.common.service.CrudService;
import com.example.modules.sys.dao.RoleDao;
import com.example.modules.sys.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends CrudService<RoleDao, Role> {


    /**
     * 根据 userId 查询对应的角色
     * @param userId
     * @return
     */
    public List<Role> findRoleByUserId(String userId){

        return dao.findRoleByUserId(userId);
    }

}

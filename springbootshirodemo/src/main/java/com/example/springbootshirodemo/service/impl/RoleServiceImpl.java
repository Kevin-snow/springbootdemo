package com.example.springbootshirodemo.service.impl;

import com.example.springbootshirodemo.mapper.PermissionMapper;
import com.example.springbootshirodemo.mapper.RoleMapper;
import com.example.springbootshirodemo.pojo.Role;
import com.example.springbootshirodemo.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Role Service implements class.
 * @author kevin
 * @date 2019/11/21
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;


    @Override
    public List<Role> getRolesByUserId(String userId) {

        List<Role> roles = roleMapper.selectRoles(userId);
        for (Role role : roles) {
            role.setPermissionList(permissionMapper.selectPermissions(role.getId()));
        }
        return roles;
    }
}

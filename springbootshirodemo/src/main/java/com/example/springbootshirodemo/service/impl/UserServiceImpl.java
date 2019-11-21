package com.example.springbootshirodemo.service.impl;

import com.example.springbootshirodemo.mapper.UserMapper;
import com.example.springbootshirodemo.pojo.User;
import com.example.springbootshirodemo.service.RoleService;
import com.example.springbootshirodemo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    private RoleService roleService;
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public User getUser(String loginId) {
        if (StringUtils.isBlank(loginId)){
            return null;
        }

        User user = userMapper.selectUserByLoginId(loginId);
        user.setRoleList(roleService.getRolesByUserId(user.getId()));
        return user;
    }
}

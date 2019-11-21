package com.example.springbootshirodemo.service;

import com.example.springbootshirodemo.pojo.Role;

import java.util.List;

/**
 * Role Service.
 * @author kevin
 * @date 2019/11/21
 */
public interface RoleService {

    /**
     * 根据用户id查询角色
     * @param userId 用户id
     * @return 角色
     */
    List<Role> getRolesByUserId(String userId);


}

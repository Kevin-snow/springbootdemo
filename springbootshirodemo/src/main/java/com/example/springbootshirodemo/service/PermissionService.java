package com.example.springbootshirodemo.service;

import com.example.springbootshirodemo.pojo.Permission;

import java.util.List;

/**
 * Permission Service.
 * @author kevin
 * @date 2019/11/21
 */
public interface PermissionService {

    /**
     * <p>
     *     获取权限
     * </p>
     * @param roleId roleId
     * @return list
     */
    List<Permission> getPermissions(Integer roleId);
}

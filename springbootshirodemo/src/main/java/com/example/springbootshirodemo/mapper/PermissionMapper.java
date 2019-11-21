package com.example.springbootshirodemo.mapper;

import com.example.springbootshirodemo.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PermissionMapper
 * @author kevin
 * @date 2019/11/21
 */
@Mapper
public interface PermissionMapper {

    /**
     * <p>
     *     根据roleId, 查询权限
     * </p>
     * @param roleId roleId
     * @return list
     */
    List<Permission> selectPermissions(@Param("roleId") Integer roleId);
}

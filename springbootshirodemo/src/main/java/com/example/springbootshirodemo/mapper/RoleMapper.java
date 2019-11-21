package com.example.springbootshirodemo.mapper;

import com.example.springbootshirodemo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Role Mapper
 * @author kevin
 * @date 2019/11/21
 */
@Mapper
public interface RoleMapper {

    /**
     * <p>
     *     根据用户id，查询用户角色
     * </p>
     * @param userId userId
     * @return roles
     */
    List<Role> selectRoles(@Param("userId") String userId);

}

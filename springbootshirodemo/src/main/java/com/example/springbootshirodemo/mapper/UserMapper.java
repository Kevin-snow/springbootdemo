package com.example.springbootshirodemo.mapper;

import com.example.springbootshirodemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * UserMapper.
 * @author kevin
 * @date 2019/11/21
 */
@Mapper
public interface UserMapper {

    /**
     * <p>
     *     根据loginId查询用户
     * </p>
     * @param loginId 登录标识
     * @return user
     */
    User selectUserByLoginId(@Param("loginId") String loginId);
}

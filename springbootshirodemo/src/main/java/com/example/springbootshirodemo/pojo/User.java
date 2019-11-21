package com.example.springbootshirodemo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *     用户.
 * </p>
 */
@Data
public class User implements Serializable {

    // 用户id
    private String id;

    // 用户名字
    private String userName;

    // 登录账号
    private String loginId;

    // 密码
    private String password;

    // 角色
    List<Role> roleList;
}

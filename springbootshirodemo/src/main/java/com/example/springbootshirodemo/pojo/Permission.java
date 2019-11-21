package com.example.springbootshirodemo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限
 * @author kevin
 * @date 2019/11/21
 */
@Data
public class Permission implements Serializable {

    // 主键
    private int id;

    // 权限字
    private String permissionKey;

    // 权限名
    private String permissionName;
}

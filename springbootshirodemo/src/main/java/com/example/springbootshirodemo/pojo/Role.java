package com.example.springbootshirodemo.pojo;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 角色
 * @author kevin
 * @date 2019/11/21
 */
@Data
public class Role implements Serializable {

    // 主键
    private int id;

    // 角色名称
    private String roleName;

    // 权限
    private List<Permission> permissionList;
}

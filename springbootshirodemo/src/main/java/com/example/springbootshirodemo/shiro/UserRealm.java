package com.example.springbootshirodemo.shiro;

import com.example.springbootshirodemo.pojo.Permission;
import com.example.springbootshirodemo.pojo.Role;
import com.example.springbootshirodemo.pojo.User;
import com.example.springbootshirodemo.service.RoleService;
import com.example.springbootshirodemo.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 重写Realm
 * @author kevin
 * @date 2019/11/21
 */
@Component
public class UserRealm extends AuthorizingRealm {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("用户权限配置！");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        for (Role role : user.getRoleList()){
            System.out.println("配置角色");
            simpleAuthorizationInfo.addRole(role.getRoleName());
            for (Permission permission : role.getPermissionList()){
                System.out.println("配置权限");
                simpleAuthorizationInfo.addStringPermission(permission.getPermissionKey());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证用户登录信息开始");
        String loginId = (String) token.getPrincipal();
        System.out.println("用户登录名：" + loginId);
        System.out.println(token.getCredentials());
        User user = userService.getUser(loginId);
        if (null == user) return null;
        System.out.println("username:" + user.getUserName() + " loginId:" + user.getLoginId()
                + " password:" + user.getPassword());
        return new SimpleAuthenticationInfo(loginId, user.getPassword()
                ,getName());
    }
}

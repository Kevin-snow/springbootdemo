package com.example.springbootshirodemo.shiro;

import com.example.springbootshirodemo.pojo.Permission;
import com.example.springbootshirodemo.pojo.Role;
import com.example.springbootshirodemo.pojo.User;
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

/**
 * 重写Realm
 * @author kevin
 * @date 2019/11/21
 */
public class UserRealm extends AuthorizingRealm {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 授权
     * @param principalCollection 参数
     * @return simpleAuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("用户权限配置！");
        User user = (User) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : user.getRoleList()){
            System.out.println("配置角色");
            for (Permission permission : role.getPermissionList()){
                System.out.println("配置权限");
                simpleAuthorizationInfo.addStringPermission(permission.getPermissionKey());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param token token
     * @return 认证信息
     * @throws AuthenticationException 认证异常
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

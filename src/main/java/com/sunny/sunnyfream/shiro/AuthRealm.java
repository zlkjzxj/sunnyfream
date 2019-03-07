package com.sunny.sunnyfream.shiro;

import com.sunny.sunnyfream.fream.model.PermissionGroup;
import com.sunny.sunnyfream.fream.model.Role;
import com.sunny.sunnyfream.fream.model.SysUser;
import com.sunny.sunnyfream.fream.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author sunny
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        //添加访问权限
        List<String> permissionList = new ArrayList<>();
        //添加访问角色
        List<String> roleNameList = new ArrayList<>();
        Set<Role> roleSet = user.getRoles();
        if (CollectionUtils.isNotEmpty(roleSet)) {
            for (Role role : roleSet) {
                roleNameList.add(role.getName());
                Set<PermissionGroup> permissionSet = role.getPermissions();
                if (CollectionUtils.isNotEmpty(permissionSet)) {
                    for (PermissionGroup permission : permissionSet) {
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(permissionList);
        authorizationInfo.addRoles(roleNameList);
        return authorizationInfo;
    }

    /**
     * 认证登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userName = usernamePasswordToken.getUsername();
//        SysUser user = userService.findByName(userName);
        SysUser user = new SysUser(11111L, "admin", "111111");
        if (user != null) {
            return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
        }
        return null;
    }
}

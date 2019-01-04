package com.example.shiro2.shiro;
import com.example.shiro2.entity.Module;
import com.example.shiro2.entity.Role;
import com.example.shiro2.entity.User;
import com.example.shiro2.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {
    /**
     *
     * 注入业务层*/
    @Autowired
    private UserService userService;
    /**授权
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        /**
         * 将权限放入到允许的集合中去*/
        List<String> permission = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if(roles.size()>0){
            for (Role role : roles) {
                Set<Module> modules = role.getModules();
                if(modules.size()>0){
                    for (Module module : modules) {
                        permission.add(module.getMname());
                    }
                }

            }
        }
        /**将权限集合放入到shrio中
         * */
        SimpleAccount account = new SimpleAccount();
        account.addStringPermissions(permission);
        return account;
    }
    /***
     * 认证登录
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /**查询数据库
         * */
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        /**身份 user.getPassword  凭证
         * */
        User user = userService.findByUsername(username);
        if(user!=null){
            SimpleAuthenticationInfo simpleAuthenticationInfo =  new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
            return simpleAuthenticationInfo;
        }
        return null ;
    }
}

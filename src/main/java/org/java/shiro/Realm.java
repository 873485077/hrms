package org.java.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/14 21 28
 * @Description: 描述信息
 */


public class Realm extends AuthorizingRealm {
    @Autowired
    private UserService service;
  //授权的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //认证的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       //获得用户凭证
        String principal = (String) token.getPrincipal();

        //根据用户凭证（用户名） 到数据库进行判断用户是否存在
        Map user = service.login(principal);

        if (user==null){
            return null;//用户名不存在
        }



       String pwd = (String) user.get("password");

        //指定加密算法，设置盐
        String salt = "hr";



        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,pwd, ByteSource.Util.bytes(salt),"myrealm");

        return info;
    }
}

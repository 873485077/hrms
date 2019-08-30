package org.java.shiro;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/14 21 26
 * @Description: 描述信息
 */

@Configuration
public class ShiroConfig {
    //授权的方法,自动注入安全管理器,SHIRO过滤器工厂类
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        //创建一个shiroFilterFactoryBean对象
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //指定，要使用的安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //如果用户没有登录，发出请求进入控制器进入登录界面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //指定shiro如何处理拦截的请求路径
        Map map = new LinkedHashMap();
        map.put("/js/**","anon");
        map.put("/css/**","anon");
        map.put("/images/**","anon");
        map.put("/layui/**","anon");
        map.put("/logout","logout");
        map.put("/forward/register","anon");
        //登录
        map.put("/**","authc");
        map.put("/favicon.ico","authc");

        //把拦截规则，关联到ShiroFiltreFactoryBean对象中
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }
    //认证的方法,指定安全管理器
    @Bean
    public SecurityManager securityManager(){
        //创建安全管理器
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //指定安全管理器，通过那一个realm类进行认证授权
        securityManager.setRealm(realm());

        return securityManager;
    }

    @Bean
    public Realm realm(){
        Realm realm = new Realm();
      realm.setCredentialsMatcher(credentialsMatcher());
        return realm;
    }

    /**
     * 指定密码的加密规程
     * @return
     */
    @Bean
    public CredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //采用md5加密
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //设置加密次数
        hashedCredentialsMatcher.setHashIterations(3);

        return hashedCredentialsMatcher;
}
}

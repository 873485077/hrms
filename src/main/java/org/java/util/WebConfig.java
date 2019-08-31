package org.java.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：方裕森
 * @date ：2019-08-25 14:31
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 该方法,用于指定,发出什么请求名称时,进行哪一个视图页面
     * @param registry

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("~进入WebConfig.java~");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/backIndex").setViewName("index");
    }*/

    /**
     * 配置拦截器,并且指定进入拦截器的规则
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置访问哪些请求时,先进入拦截器
        String[] pathPattern={"/index"}; //"/forward/**"
        //配置拦截
        registry.addInterceptor(new UserInterceptor()).addPathPatterns(pathPattern);
    }
}

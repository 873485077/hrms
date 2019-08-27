package org.java.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ：方裕森
 * @date ：2019-08-26 15:01
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 */
public class UserInterceptor implements HandlerInterceptor {
    /**
     * 进入控制前之前执行的方法: 该方法适合判断用户是否拥有访问权限,如果有,则进入控制器,如果没有则不进入
     * 前置拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("~进入前置拦截器~");
        //通过request获得session
        HttpSession session = request.getSession();
        //session中获得username, 如果为空则未登录,跳转login.html进行登录
        String username = (String) session.getAttribute("username");
        if (username == null || "".equals(username)){
            //未登录 //重定向到登录页面
            response.sendRedirect("/login");
            return false;
        }else{
            //已登录
            return true;
        }


    }

    /**
     * 后置拦截
     * 控制器方法执行完成以后,才会进入该方法,适合用于日志记录
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 本次请求结束之前执行的方法, 适合释放资源
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

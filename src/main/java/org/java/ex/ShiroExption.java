package org.java.ex;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 郑志高
 * @Date: 2019/8/14 22 07
 * @Description: 描述信息
 */

@Component
public class ShiroExption implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获得异常信息
        String msg = e.getMessage();

        //创建modelAndView
        ModelAndView mv = new ModelAndView("/login");

        mv.addObject("msg",msg);

        return mv;
    }
}

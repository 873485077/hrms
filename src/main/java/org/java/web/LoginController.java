package org.java.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/13 15 24
 * @Description: 描述信息
 */

@Controller
public class LoginController {
//    @RequestMapping("/forward/{target}")
//    public String forward(@PathVariable("target") String target){
//        return "/"+target;
//    }


    @GetMapping("/")
    public String login(HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        Map map = (Map) subject.getPrincipal();
        session.setAttribute("user",map);
        return "/index";
    }


    //该方法只有未登录或登录失败才会进入
    @RequestMapping("/login")
    public String login(HttpServletRequest request) throws Exception {
        //获取错误信息shiroLoginFailure,如果由于未登录进入，该值为空
        String err = (String) request.getAttribute("shiroLoginFailure");

        //判断消息是否为空
        if (err!=null){
           if(err.endsWith("UnknownAccountException")){
               throw  new Exception("用户名不存在");
           }
           if (err.endsWith("IncorrectCredentialsException")){
               throw new Exception("密码错误");
           }
        }

        return "/login";
    }



}

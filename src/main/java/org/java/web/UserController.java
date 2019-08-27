package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author ：方裕森
 * @date ：2019-08-26 15:11
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 * 用户的控制器,进行用户登录
 */
@Controller
public class UserController {

    @PostMapping("/login")
    public String login(String username, String passwrod, HttpSession session){
        System.out.println("~用户尝试登录~"+username);
        session.setAttribute("username", username);
        return "redirect:/backIndex";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("~用户退出~"+session.getAttribute("username"));
        session.removeAttribute("username");
        return "redirect:/login";
    }



}

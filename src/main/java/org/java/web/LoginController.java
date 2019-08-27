package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：方裕森
 * @date ：2019-08-15 10:01
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        System.out.println("~跳转登录界面~");
        return "/login";
    }
}

package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author ：方裕森
 * @date ：2019-08-15 10:01
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 */
@Controller

public class LoginController {

    @PostMapping("/login")
    public String login(){
        System.out.println("~登录成功~");
        return "redirect:/index";
    }
}

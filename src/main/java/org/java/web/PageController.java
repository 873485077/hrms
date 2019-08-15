package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: 马果
 * @Date: 2019/7/21 10:20
 * @Description:
 */
@Controller
public class PageController {
    @GetMapping("/index")
    public String index(){
        return "/index";
    }

    @GetMapping("/forward/{page}")
    public String forward(@PathVariable("page") String page){
        return "/"+page;
    }

    @GetMapping("/forward/{pipe}/{page}")
    public String forward1(@PathVariable("pipe") String pipe,@PathVariable("page") String page){
        return "/"+pipe+"/"+page;
    }

    @GetMapping("/forward/{pipe}/{pipe1}/{page}")
    public String forward1(@PathVariable("pipe") String pipe,@PathVariable("pipe1") String pipe1,@PathVariable("page") String page){
        return "/"+pipe+"/"+pipe1+"/"+page;
    }
}

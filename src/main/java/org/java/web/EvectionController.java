package org.java.web;

import org.java.entity.Evection;
import org.java.service.EvectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:shuxiang
 * @date:2019/8/21 {HOUR}:{MTNUTE}
 * @Description:   //出差管理
 */
@RestController
public class EvectionController {
    @Autowired
    private EvectionService evectionService;

    @GetMapping("Evection")
    public Map  getList(Integer page,Integer limit){

         Map map=new HashMap();

         List<Evection> list= evectionService.getList(page,limit);
         int count=evectionService.getCount();

             map.put("code",0);
             map.put("msg","");
             map.put("count",count);
             map.put("data",list);

             return map;
    }
}

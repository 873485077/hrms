package org.java.web;

import org.java.entity.Assess;
import org.java.service.AssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:shuxiang
 * @date:2019/8/26 {HOUR}:{MTNUTE}
 * @Description:
 */
@RestController
public class AssessController {

    @Autowired
    private AssessService assessService;

    @GetMapping("Assess")
    public Map getList(Integer page,Integer limit){
        Map map=new HashMap();
        List<Assess> list=assessService.getList(page,limit);

        int count=assessService.getCount();

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);

        return map;
    }

}

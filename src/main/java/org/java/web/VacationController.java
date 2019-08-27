package org.java.web;

import org.java.entity.Vacation;
import org.java.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:shuxiang
 * @date:2019/8/22 {HOUR}:{MTNUTE}
 * @Description:  //休假管理
 */
@RestController
public class VacationController {
    @Autowired
    private VacationService vacationService;

    @GetMapping ("init")
    public Map getList(Integer page,Integer limit){

        Map map=new HashMap();

        List<Vacation> list=vacationService.getList(page,limit);

        int count=vacationService.getCount();

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);


        return map;
    }
}

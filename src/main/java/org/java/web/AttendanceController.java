package org.java.web;

import org.java.entity.Attendance;
import org.java.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:shuxiang
 * @date:2019/8/19 {HOUR}:{MTNUTE}
 * @Description:   //考勤记录
 */
@RestController
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;


    @GetMapping("attendance")
    public Map getList(Integer page,Integer limit){  //当前页 ，每一页显示条数
        Map map=new HashMap();
        List<Attendance> list=attendanceService.getList(page,limit);
        int count=attendanceService.getCount();

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);



       return map;

    }


}

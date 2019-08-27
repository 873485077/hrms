package org.java.service;

import org.java.entity.Attendance;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/19 {HOUR}:{MTNUTE}
 * @Description:  //考勤记录
 */

public interface AttendanceService {

    public List<Attendance> getList(int page,int rows);//当前页 每页条数

    public int getCount();
}

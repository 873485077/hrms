package org.java.service.impl;

import org.java.dao.AttendanceMapper;
import org.java.entity.Attendance;
import org.java.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/20 {HOUR}:{MTNUTE}
 * @Description:  //考勤记录
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper mapper;

    @Override
    public List<Attendance> getList(int page, int rows) {
        int start=(page-1)*rows;
        return mapper.getList(start,rows);
    }

    @Override
    public int getCount() {
        return mapper.getCount();
    }
}

package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.Attendance;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/19 {HOUR}:{MTNUTE}
 * @Description:  //考勤记录
 */
@Mapper
public interface AttendanceMapper {

    public List<Attendance> getList(@Param("start") int start,@Param("rows") int rows);//开始页 每页显示条数

    public int getCount();
}

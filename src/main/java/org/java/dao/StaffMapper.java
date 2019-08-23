package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 安平
 * @date 2019-08-18 10:02
 */
@Mapper
public interface StaffMapper {

    public List<Map> staffFind(@Param("start") int start, @Param("rows") int rows);

    public int staffGetCount();

    public List<Map> staffDetail(int Staff_number);

    public void staffAdd(Map map);

    public Map  updateStaff(int staff_number);

    public void staffUpdate(Map map);

    public List<Map> contractFind(@Param("start") int start, @Param("rows") int rows);

    public int contractGetCount();

    public List<Map> contractDetail(int Staff_number);

    public List<Map> demissionFind(@Param("start") int start, @Param("rows") int rows);

    public int demissionGetCount();

    public List<Map> demissionDetail(int Staff_number);


}

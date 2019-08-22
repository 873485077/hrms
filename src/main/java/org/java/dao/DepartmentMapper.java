package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.StaffDemand;

import java.util.List;

/**
 * @author ：方裕森
 * @date ：2019-08-16 15:45
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 */
@Mapper
public interface DepartmentMapper {

    /**
     * 查询人员需求征集表
     * @param start
     * @param rows
     * @return
     */
    List<StaffDemand> getStaffDemand(@Param("start") int start, @Param("rows") int rows);

    /**
     * 获得人员需求征集表的数据数量（行数）
     * @return
     */
    int getStaffDemandCount();

}

package org.java.service;

import org.apache.ibatis.annotations.Param;
import org.java.entity.StaffDemand;

import java.util.List;

/**
 * @author ：方裕森
 * @date ：2019-08-18 20:36
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 */
public interface DepartmentService {

    /**
     * 查询人员需求征集表
     * @paramzeturn
     */
    List<StaffDemand> getStaffDemand(int page, int rows);
    int getStaffDemandCount();

    /**
     * 征集表审核完成
     */
    List<StaffDemand> getStaffDemandApproved(@Param("start") int start, @Param("rows") int rows);
    int getStaffDemandApprovedCount();

}

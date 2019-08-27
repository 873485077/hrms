package org.java.service.impl;

import org.java.dao.DepartmentMapper;
import org.java.entity.StaffDemand;
import org.java.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ：方裕森
 * @date ：2019-08-18 20:41
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<StaffDemand> getStaffDemand(int page, int rows) {
        int start = (page - 1) * rows;
        return departmentMapper.getStaffDemand(start, rows);
    }

    @Override
    public int getStaffDemandCount() {
        return  departmentMapper.getStaffDemandCount();
    }

    @Override
    public List<StaffDemand> getStaffDemandApproved(int page, int rows) {
        int start = (page - 1) * rows;
        return departmentMapper.getStaffDemandApproved(start, rows);
    }

    @Override
    public int getStaffDemandApprovedCount() {
        return  departmentMapper.getStaffDemandApprovedCount();
    }

}

package org.java.service.impl;

import org.java.dao.StaffMapper;
import org.java.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 安平
 * @date 2019-08-18 10:03
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper mapper;

    @Override
    public List<Map> staffFind(int page, int rows) {
        //根据当前页,计算开始下标
        int start = (page-1)*rows;
        List<Map> list = mapper.staffFind(start,rows);
        return list;
    }

    @Override
    public int staffGetCount() {
        return mapper.staffGetCount();
    }

    @Override
    public List<Map> staffDetail(int staff_number) {
        return mapper.staffDetail(staff_number);
    }

    @Override
    public void staffAdd(Map map) {
        mapper.staffAdd(map);
    }

    @Override
    public Map updateStaff(int staff_number) {
        return mapper.updateStaff(staff_number);
    }

    @Transactional
    @Override
    public void staffUpdate(Map map) {
        mapper.staffUpdate(map);
    }

    @Override
    public List<Map> contractFind(int page, int rows) {
        int start = (page-1)*rows;
        return mapper.contractFind(start,rows);
    }

    @Override
    public List<Map> contractDetail(int staff_number) {
        return mapper.contractDetail(staff_number);
    }

    @Override
    public List<Map> demissionFind(int page, int rows) {
        int start = (page-1)*rows;
        return mapper.demissionFind(start,rows);
    }

    @Override
    public List<Map> demissionDetail(int staff_number) {
        return mapper.demissionDetail(staff_number);
    }
}

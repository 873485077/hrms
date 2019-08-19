package org.java.service.impl;

import org.java.dao.StaffMapper;
import org.java.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Map> staff_find(int page, int rows) {
        //根据当前页,计算开始下标
        int start = (page-1)*rows;
        List<Map> list = mapper.staff_find(start,rows);
        return list;
    }

    @Override
    public int staff_getCount() {
        return mapper.staff_getCount();
    }

    @Override
    public List<Map> staff_detail(int staff_number) {
        return mapper.staff_detail(staff_number);
    }

    @Override
    public void staff_add(Map map) {
        mapper.staff_add(map);
    }

    @Override
    public List<Map> contract_find() {
        return mapper.contract_find();
    }

    @Override
    public List<Map> contract_detail(int staff_number) {
        return mapper.contract_detail(staff_number);
    }

    @Override
    public List<Map> demission_find() {
        return mapper.demission_find();
    }

    @Override
    public List<Map> demission_detail(int staff_number) {
        return mapper.demission_detail(staff_number);
    }
}

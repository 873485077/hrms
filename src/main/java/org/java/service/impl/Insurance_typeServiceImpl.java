package org.java.service.impl;

import org.java.dao.Insurance_typeMapper;
import org.java.service.Insurance_typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/22 14 33
 * @Description: 描述信息
 */

@Service
public class Insurance_typeServiceImpl implements Insurance_typeService {
    @Autowired
    private Insurance_typeMapper mapper;

    @Override
    public int getCount() {
        return mapper.getCount();
    }

    @Override
    public List<Map> findInsurance_typeMapper(int page,int rows) {
        //根据当前页计算开始下标
        int start = (page-1)*rows;

        List<Map> list = mapper.findInsurance_typeMapper(start,rows);
        return list;
    }
    @Transactional
    @Override
    public void add(Map map) {
        mapper.add(map);
    }

    @Override
    public Map findById(int insurance_type_id) {
        return mapper.findById(insurance_type_id);
    }
    @Transactional
    @Override
    public void update(Map map) {
        mapper.update(map);
    }
    @Transactional
    @Override
    public void del(int insurance_type_id) {
        mapper.del(insurance_type_id);
    }
}

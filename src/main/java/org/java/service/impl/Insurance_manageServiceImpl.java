package org.java.service.impl;

import org.java.dao.Insurance_manageMapper;
import org.java.service.Insurance_manageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/26 23 19
 * @Description: 描述信息
 */

@Service
public class Insurance_manageServiceImpl implements Insurance_manageService {
    @Autowired
    private Insurance_manageMapper manageMapper;

    @Override
    public int getCount() {
        return manageMapper.getCount();
    }

    @Override
    public List<Map> findinsurance_manage(int pageB,int rowsB) {

        //根据当前页计算开始下标
        int startB =( pageB-1)*rowsB;

        List<Map> list = manageMapper.findinsurance_manage(startB,rowsB);
        return list;
    }

    @Override
    public Map findById(int insurance_id) {
        return manageMapper.findById(insurance_id);
    }

    @Transactional
    @Override
    public void update(Map map) {
        manageMapper.update(map);
    }

    @Transactional
    @Override
    public void del(int insurance_id) {
        manageMapper.del(insurance_id);
    }

    @Transactional
    @Override
    public void add(Map map) {

        manageMapper.add(map);
    }
}

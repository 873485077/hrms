package org.java.service.impl;

import org.java.dao.EvectionMapper;
import org.java.entity.Evection;
import org.java.service.EvectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/21 {HOUR}:{MTNUTE}
 * @Description:    //出差管理
 */
@Service
public class EvectionServiceImpl implements EvectionService {
    @Autowired
    private EvectionMapper mapper;

    @Override
    public List<Evection> getList(int page,int rows) {
       int start=(page-1)*rows;
        return mapper.getList(start,rows);
    }

    @Override
    public int getCount() {
        return mapper.getCount();
    }
}

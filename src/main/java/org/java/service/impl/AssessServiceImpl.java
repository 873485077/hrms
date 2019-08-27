package org.java.service.impl;

import org.java.dao.AssessMapper;
import org.java.entity.Assess;
import org.java.service.AssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/26 {HOUR}:{MTNUTE}
 * @Description:
 */
@Service
public class AssessServiceImpl implements AssessService {
    @Autowired
    private AssessMapper mapper;

    @Override
    public List<Assess> getList(int page,int rows) {
        int start=(page-1)*rows;

        return mapper.getList(start,rows);
    }

    @Override
    public int getCount() {
        return mapper.getCount();
    }
}

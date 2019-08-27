package org.java.service.impl;

import org.java.dao.VacationMapper;
import org.java.entity.Vacation;
import org.java.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/22 {HOUR}:{MTNUTE}
 * @Description:  //休假管理
 */
@Service
public class VacationServiceImpl implements VacationService {
    @Autowired
    private VacationMapper mapper;

    @Override
    public List<Vacation> getList(int page, int rows) {

        int start=(page-1)*rows;

        return mapper.getList(start,rows);
    }

    @Override
    public int getCount() {
        return mapper.getCount();
    }
}

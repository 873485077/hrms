package org.java.service;

import org.java.entity.Vacation;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/22 {HOUR}:{MTNUTE}
 * @Description:  //休假管理
 */

public interface VacationService {

    public List<Vacation> getList(int page,int rows);

    public int getCount();
}

package org.java.service;

import org.java.entity.Evection;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/21 {HOUR}:{MTNUTE}
 * @Description:   //出差管理
 */

public interface EvectionService {

    public List<Evection> getList(int page,int rows);

    public int getCount();
}

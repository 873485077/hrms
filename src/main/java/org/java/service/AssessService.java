package org.java.service;

import org.java.entity.Assess;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/26 {HOUR}:{MTNUTE}
 * @Description:
 */

public interface AssessService {

    public List<Assess> getList(int page,int rows);

    public int getCount();

}

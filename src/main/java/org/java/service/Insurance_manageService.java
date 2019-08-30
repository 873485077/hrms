package org.java.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/26 23 16
 * @Description: 描述信息
 */


public interface Insurance_manageService {

    public List<Map> findinsurance_manage(int pageB, int rowsB);

    public int getCount();

    public void add(Map map);

    public Map findById(int insurance_id);

    public void update(Map map);

    public void del(int insurance_id);
}

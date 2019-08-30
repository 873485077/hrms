package org.java.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/22 14 32
 * @Description: 描述信息
 */


public interface Insurance_typeService {
    /**
     *
     * @param page 当前页
     * @param rows 每一页要显示的条数
     * @return
     */
    public List<Map> findInsurance_typeMapper(int page, int rows);
    //返回数据总数的方法
    public int getCount();

    public void add(Map map);

    public Map findById(int insurance_type_id);

    public void update(Map map);

    public void del(int insurance_type_id);
}

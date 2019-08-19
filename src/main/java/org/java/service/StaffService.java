package org.java.service;

import java.util.List;
import java.util.Map;

/**
 * @author 安平
 * @date 2019-08-18 10:03
 */
public interface StaffService {

    public List<Map> staff_find(int page, int rows);

    public int staff_getCount();

    public List<Map> staff_detail(int Staff_number);

    public void staff_add(Map map);

    public List<Map> contract_find();

    public List<Map> contract_detail(int Staff_number);

    public List<Map> demission_find();

    public List<Map> demission_detail(int Staff_number);

}

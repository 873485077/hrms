package org.java.service;

import java.util.List;
import java.util.Map;

/**
 * @author 安平
 * @date 2019-08-18 10:03
 */
public interface StaffService {

    public List<Map> staffFind(int page, int rows);

    public int staffGetCount();

    public List<Map> staffDetail(int Staff_number);

    public void staffAdd(Map map);

    public Map updateStaff(int staff_number);

    public void staffUpdate(Map map);

    public List<Map> contractFind();

    public List<Map> contractDetail(int Staff_number);

    public List<Map> demissionFind();

    public List<Map> demissionDetail(int Staff_number);

}

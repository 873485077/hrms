package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/26 23 15
 * @Description: 描述信息
 */

@Mapper
public interface Insurance_manageMapper {

    public List<Map> findinsurance_manage(@Param("startB") int startB, @Param("rowsB") int rowsB);

    //返回数据总数的方法
    public int getCount();

    public  void add(Map map);

    public Map findById(int insurance_type_id);

    public void update(Map map);

    public void del(int insurance_type_id);
}

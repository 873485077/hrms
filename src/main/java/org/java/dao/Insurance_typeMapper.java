package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/22 11 42
 * @Description: 描述信息
 */

@Mapper
public interface Insurance_typeMapper {
    //显示保险类型表所有数据
    public List<Map> findInsurance_typeMapper(@Param("start") int start, @Param("rows") int rows);

    public int getCount();

    public  void add(Map map);

    public Map findById(int insurance_type_id);

    public void update(Map map);

    public void del(int insurance_type_id);


}

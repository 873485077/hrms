package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.Evection;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/21 {HOUR}:{MTNUTE}
 * @Description:   //出差管理
 */
@Mapper
public interface EvectionMapper {

     public List<Evection> getList(@Param("start") int start, @Param("rows") int rows);

     public int getCount();
}

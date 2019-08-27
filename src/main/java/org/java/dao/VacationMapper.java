package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.Vacation;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/22 {HOUR}:{MTNUTE}
 * @Description:  //休假管理
 */
@Mapper
public interface VacationMapper {

    public List<Vacation> getList(@Param("start") int start, @Param("rows") int rows);

    public int getCount();
}

package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.Assess;

import java.util.List;

/**
 * @Author:shuxiang
 * @date:2019/8/26 {HOUR}:{MTNUTE}
 * @Description:
 */
@Mapper
public interface AssessMapper {

    public List<Assess> getList(@Param("start") int start, @Param("rows") int rows);

    public int getCount();
}

package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.HrStaffDemand;

import java.util.Map;

@Mapper
public interface HrStaffDemandMapper {
    int deleteByPrimaryKey(String demandId);

    int insert(HrStaffDemand record);

    int insertSelective(Map map);

    HrStaffDemand selectByPrimaryKey(String demandId);

    int updateByPrimaryKeySelective(HrStaffDemand record);

    int updateByPrimaryKey(HrStaffDemand record);
}
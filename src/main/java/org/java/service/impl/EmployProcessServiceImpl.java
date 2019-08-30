package org.java.service.impl;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.logging.log4j.core.util.UuidUtil;
import org.java.dao.HrStaffDemandMapper;
import org.java.entity.HrStaffDemand;
import org.java.service.EmployProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author ：方裕森
 * @date ：2019-08-28 21:36
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 */
@Service
public class EmployProcessServiceImpl implements EmployProcessService {

    @Autowired
    private HrStaffDemandMapper mapper; //hr_staff_demand数据表 Dao层
    @Autowired
    private RuntimeService runtimeService; //流程实例服务
    /**
     * 添加职员需求征集申请表
     * 1/启动流程实例(需要服务: runtimeService)
     * 2/添加业务数据
     * @return
     */
    @Override
    public int createStaffDemand(Map map) {
        /* ****启动流程实例**** */
        //生成uuid,作为流程实例的BusinessKey,以及业务表的主键,它们之间相关联
        String id = UuidUtil.getTimeBasedUuid().toString();
        //指定流程实例
        String processDefinitionKey = "employ1";
        //启动流程实例
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(processDefinitionKey, id);

        /* ****向业务表添加数据**** */
        map.put("creatTime",new Date() ); //创建时间
        map.put("demandId",id ); //业务主键
        map.put("processinstanceId", instance.getProcessInstanceId()); //流程实例id
        map.put("demandStatus", "送审中");
        System.out.println(map);
        int i = mapper.insertSelective(map);//调用Dao层 返回写入成功的数目

        return i;
    }

}

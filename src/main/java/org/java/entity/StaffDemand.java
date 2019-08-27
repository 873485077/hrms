package org.java.entity;

import java.io.Serializable;

/**
 * @author ：方裕森
 * @date ：2019-08-18 21:59
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 */

public class StaffDemand implements Serializable {

    private String demand_status;
    private String demand_title;
    private String department_name;
    private Integer processInstance_id;

    public String getDemand_status() {
        return demand_status;
    }

    public void setDemand_status(String demand_status) {
        this.demand_status = demand_status;
    }

    public String getDemand_title() {
        return demand_title;
    }

    public void setDemand_title(String demand_title) {
        this.demand_title = demand_title;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Integer getProcessInstance_id() {
        return processInstance_id;
    }

    public void setProcessInstance_id(Integer processInstance_id) {
        this.processInstance_id = processInstance_id;
    }

    @Override
    public String toString() {
        return "StaffDemand{" +
                "demand_status='" + demand_status + '\'' +
                ", demand_title='" + demand_title + '\'' +
                ", department_name='" + department_name + '\'' +
                ", processInstance_id=" + processInstance_id +
                '}';
    }

    public StaffDemand() {
    }

    public StaffDemand(String demand_status, String demand_title, String department_name, Integer processInstance_id) {
        this.demand_status = demand_status;
        this.demand_title = demand_title;
        this.department_name = department_name;
        this.processInstance_id = processInstance_id;
    }
}

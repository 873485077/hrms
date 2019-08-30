package org.java.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：方裕森
 * @date ：2019-08-18 21:59
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 */
@Alias("StaffDemand")
public class StaffDemand implements Serializable {

    private String demand_id;
    private String demand_title;
    private String salary_range;
    private String salary_min;
    private String salary_max;
    private String demand_amount;
    private String recruit_way;
    private Date start_date;
    private Date finish_date;
    private String job_require;
    private String job_content;
    private String remark;
    private String creat_user;
    private Date creat_time;
    private Date end_time;
    private String processInstance_id;
    private String demand_status;
    private String department_name; //部门
    private String department_id; //部门id
    private String duty_name; //职务
    private String duty_id; //职务id

    @Override
    public String toString() {
        return "StaffDemand{" +
                "demand_id='" + demand_id + '\'' +
                ", demand_title='" + demand_title + '\'' +
                ", salary_range='" + salary_range + '\'' +
                ", salary_min='" + salary_min + '\'' +
                ", salary_max='" + salary_max + '\'' +
                ", demand_amount='" + demand_amount + '\'' +
                ", recruit_way='" + recruit_way + '\'' +
                ", start_date=" + start_date +
                ", finish_date=" + finish_date +
                ", job_require='" + job_require + '\'' +
                ", job_content='" + job_content + '\'' +
                ", remark='" + remark + '\'' +
                ", creat_user='" + creat_user + '\'' +
                ", creat_time=" + creat_time +
                ", end_time=" + end_time +
                ", processInstance_id='" + processInstance_id + '\'' +
                ", demand_status='" + demand_status + '\'' +
                ", department_name='" + department_name + '\'' +
                ", department_id='" + department_id + '\'' +
                ", duty_name='" + duty_name + '\'' +
                ", duty_id='" + duty_id + '\'' +
                '}';
    }

    public String getDemand_id() {
        return demand_id;
    }

    public void setDemand_id(String demand_id) {
        this.demand_id = demand_id;
    }

    public String getDemand_title() {
        return demand_title;
    }

    public void setDemand_title(String demand_title) {
        this.demand_title = demand_title;
    }

    public String getSalary_range() {
        return salary_range;
    }

    public void setSalary_range(String salary_range) {
        this.salary_range = salary_range;
    }

    public String getSalary_min() {
        return salary_min;
    }

    public void setSalary_min(String salary_min) {
        this.salary_min = salary_min;
    }

    public String getSalary_max() {
        return salary_max;
    }

    public void setSalary_max(String salary_max) {
        this.salary_max = salary_max;
    }

    public String getDemand_amount() {
        return demand_amount;
    }

    public void setDemand_amount(String demand_amount) {
        this.demand_amount = demand_amount;
    }

    public String getRecruit_way() {
        return recruit_way;
    }

    public void setRecruit_way(String recruit_way) {
        this.recruit_way = recruit_way;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    public String getJob_require() {
        return job_require;
    }

    public void setJob_require(String job_require) {
        this.job_require = job_require;
    }

    public String getJob_content() {
        return job_content;
    }

    public void setJob_content(String job_content) {
        this.job_content = job_content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreat_user() {
        return creat_user;
    }

    public void setCreat_user(String creat_user) {
        this.creat_user = creat_user;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getProcessInstance_id() {
        return processInstance_id;
    }

    public void setProcessInstance_id(String processInstance_id) {
        this.processInstance_id = processInstance_id;
    }

    public String getDemand_status() {
        return demand_status;
    }

    public void setDemand_status(String demand_status) {
        this.demand_status = demand_status;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDuty_name() {
        return duty_name;
    }

    public void setDuty_name(String duty_name) {
        this.duty_name = duty_name;
    }

    public String getDuty_id() {
        return duty_id;
    }

    public void setDuty_id(String duty_id) {
        this.duty_id = duty_id;
    }
}

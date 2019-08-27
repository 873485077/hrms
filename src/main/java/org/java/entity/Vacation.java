package org.java.entity;

import java.io.Serializable;

/**
 * @Author:shuxiang
 * @date:2019/8/22 {HOUR}:{MTNUTE}
 * @Description:   //休假管理
 */

public class Vacation implements Serializable {

    private  Integer vacationId;
    private  String staffId;
    private  String vacationDate;
    private  String vacationStart;
    private  String vacationEnd;
    private  String vacationType;
    private  String vacationRemark;

    public Integer getVacationId() {
        return vacationId;
    }

    public void setVacationId(Integer vacationId) {
        this.vacationId = vacationId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getVacationDate() {
        return vacationDate;
    }

    public void setVacationDate(String vacationDate) {
        this.vacationDate = vacationDate;
    }

    public String getVacationStart() {
        return vacationStart;
    }

    public void setVacationStart(String vacationStart) {
        this.vacationStart = vacationStart;
    }

    public String getVacationEnd() {
        return vacationEnd;
    }

    public void setVacationEnd(String vacationEnd) {
        this.vacationEnd = vacationEnd;
    }

    public String getVacationType() {
        return vacationType;
    }

    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
    }

    public String getVacationRemark() {
        return vacationRemark;
    }

    public void setVacationRemark(String vacationRemark) {
        this.vacationRemark = vacationRemark;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "vacationId=" + vacationId +
                ", staffId='" + staffId + '\'' +
                ", vacationDate='" + vacationDate + '\'' +
                ", vacationStart='" + vacationStart + '\'' +
                ", vacationEnd='" + vacationEnd + '\'' +
                ", vacationType='" + vacationType + '\'' +
                ", vacationRemark='" + vacationRemark + '\'' +
                '}';
    }
}

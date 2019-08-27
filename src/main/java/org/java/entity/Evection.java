package org.java.entity;

import java.io.Serializable;

/**
 * @Author:shuxiang
 * @date:2019/8/21 {HOUR}:{MTNUTE}
 * @Description:    //出差管理
 */

public class Evection implements Serializable {


    private Integer evectionId;
    private String staffId;
    private String evectionDate;
    private String evectionType;
    private String evectionStart;
    private String evectionEnd;
    private String evectionRemark;

    public Integer getEvectionId() {
        return evectionId;
    }

    public void setEvectionId(Integer evectionId) {
        this.evectionId = evectionId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getEvectionDate() {
        return evectionDate;
    }

    public void setEvectionDate(String evectionDate) {
        this.evectionDate = evectionDate;
    }

    public String getEvectionType() {
        return evectionType;
    }

    public void setEvectionType(String evectionType) {
        this.evectionType = evectionType;
    }

    public String getEvectionStart() {
        return evectionStart;
    }

    public void setEvectionStart(String evectionStart) {
        this.evectionStart = evectionStart;
    }

    public String getEvectionEnd() {
        return evectionEnd;
    }

    public void setEvectionEnd(String evectionEnd) {
        this.evectionEnd = evectionEnd;
    }

    public String getEvectionRemark() {
        return evectionRemark;
    }

    public void setEvectionRemark(String evectionRemark) {
        this.evectionRemark = evectionRemark;
    }

    @Override
    public String toString() {
        return "Evection{" +
                "evectionId=" + evectionId +
                ", staffId='" + staffId + '\'' +
                ", evectionDate='" + evectionDate + '\'' +
                ", evectionType='" + evectionType + '\'' +
                ", evectionStart='" + evectionStart + '\'' +
                ", evectionEnd='" + evectionEnd + '\'' +
                ", evectionRemark='" + evectionRemark + '\'' +
                '}';
    }
}

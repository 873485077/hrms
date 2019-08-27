package org.java.entity;

import java.io.Serializable;

/**
 * @Author:shuxiang
 * @date:2019/8/26 {HOUR}:{MTNUTE}
 * @Description:
 */

public class Assess implements Serializable {

    private Integer assessId;
    private String staffId;
    private String assessType;
    private String assessQuarter;
    private Integer assessScore;
    private String assessDate;

    public Integer getAssessId() {
        return assessId;
    }

    public void setAssessId(Integer assessId) {
        this.assessId = assessId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getAssessType() {
        return assessType;
    }

    public void setAssessType(String assessType) {
        this.assessType = assessType;
    }

    public String getAssessQuarter() {
        return assessQuarter;
    }

    public void setAssessQuarter(String assessQuarter) {
        this.assessQuarter = assessQuarter;
    }

    public Integer getAssessScore() {
        return assessScore;
    }

    public void setAssessScore(Integer assessScore) {
        this.assessScore = assessScore;
    }

    public String getAssessDate() {
        return assessDate;
    }

    public void setAssessDate(String assessDate) {
        this.assessDate = assessDate;
    }

    @Override
    public String toString() {
        return "Assess{" +
                "assessId=" + assessId +
                ", staffId='" + staffId + '\'' +
                ", assessType='" + assessType + '\'' +
                ", assessQuarter='" + assessQuarter + '\'' +
                ", assessScore=" + assessScore +
                ", assessDate='" + assessDate + '\'' +
                '}';
    }
}

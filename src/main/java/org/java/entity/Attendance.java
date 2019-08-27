package org.java.entity;

import java.io.Serializable;

/**
 * @Author:shuxiang
 * @date:2019/8/19 {HOUR}:{MTNUTE}
 * @Description:  //考勤记录
 */

public class Attendance implements Serializable {
    private Integer attendanceId;
    private String staffId;
    private String attendanceDate;
    private String attendanceType;
    private String attendanceRemark;


    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(String attendanceType) {
        this.attendanceType = attendanceType;
    }

    public String getAttendanceRemark() {
        return attendanceRemark;
    }

    public void setAttendanceRemark(String attendanceRemark) {
        this.attendanceRemark = attendanceRemark;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", staffId='" + staffId + '\'' +
                ", attendanceDate='" + attendanceDate + '\'' +
                ", attendanceType='" + attendanceType + '\'' +
                ", attendanceRemark='" + attendanceRemark + '\'' +
                '}';
    }
}

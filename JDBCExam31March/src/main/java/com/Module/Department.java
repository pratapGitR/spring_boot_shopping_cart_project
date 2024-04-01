package com.Module;

public class Department {
    private Integer deptID;
    private String deptName;
    private String deptLocation;
    private Integer studID;

    public Integer getDeptID() {
        return deptID;
    }

    public void setDeptID(Integer deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLocation() {
        return deptLocation;
    }

    public void setDeptLocation(String deptLocation) {
        this.deptLocation = deptLocation;
    }

    public Integer getStudID() {
        return studID;
    }

    public void setStudID(Integer studID) {
        this.studID = studID;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptID=" + deptID +
                ", depName='" + deptName + '\'' +
                ", depLocation='" + deptLocation + '\'' +
                ", studID=" + studID +
                '}';
    }
}

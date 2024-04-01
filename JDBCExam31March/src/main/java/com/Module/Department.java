package com.Module;

public class Department {
    private Integer deptID;
    private String depName;
    private String depLocation;
    private Integer studID;

    public Integer getDeptID() {
        return deptID;
    }

    public void setDeptID(Integer deptID) {
        this.deptID = deptID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepLocation() {
        return depLocation;
    }

    public void setDepLocation(String depLocation) {
        this.depLocation = depLocation;
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
                ", depName='" + depName + '\'' +
                ", depLocation='" + depLocation + '\'' +
                ", studID=" + studID +
                '}';
    }
}

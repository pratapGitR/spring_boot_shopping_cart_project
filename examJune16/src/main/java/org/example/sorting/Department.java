package org.example.sorting;

public class Department {

    public int deptId;
    public String deptName;

    public String depLocation;

    public Department(int deptId, String deptName, String depLocation) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.depLocation = depLocation;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", depLocation='" + depLocation + '\'' +
                '}';
    }
}

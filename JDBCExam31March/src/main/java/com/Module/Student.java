package com.Module;

import java.util.Date;

public class Student {
    private Integer studID;
    private String studName;
    private Integer studAge;
    private Date studDOB;

    public Integer getStudID() {
        return studID;
    }

    public void setStudID(Integer studID) {
        this.studID = studID;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public Integer getStudAge() {
        return studAge;
    }

    public void setStudAge(Integer studAge) {
        this.studAge = studAge;
    }

    public Date getStudDOB() {
        return studDOB;
    }

    public void setStudDOB(Date studDOB) {
        this.studDOB = studDOB;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studID=" + studID +
                ", studName='" + studName + '\'' +
                ", studAge=" + studAge +
                ", studDOB=" + studDOB +
                '}';
    }
}

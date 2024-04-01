package com.Module;

public class SubjectScore {
    private Integer subID;
    private String subName;
    private Integer sub_score;
    private Integer studID;

    public Integer getSubID() {
        return subID;
    }

    public void setSubID(Integer subID) {
        this.subID = subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public Integer getSub_score() {
        return sub_score;
    }

    public void setSub_score(Integer sub_score) {
        this.sub_score = sub_score;
    }

    public Integer getStudID() {
        return studID;
    }

    public void setStudID(Integer studID) {
        this.studID = studID;
    }

    @Override
    public String toString() {
        return "SubjectScore{" +
                "subID=" + subID +
                ", subName='" + subName + '\'' +
                ", sub_score=" + sub_score +
                ", studID=" + studID +
                '}';
    }
}

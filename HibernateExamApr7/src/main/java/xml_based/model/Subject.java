package xml_based.model;

public class Subject {
    private Integer subId;
    private String subName;

    public Subject(String subName) {
        this.subName = subName;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subId=" + subId +
                ", subName='" + subName + '\'' +
                '}';
    }
}

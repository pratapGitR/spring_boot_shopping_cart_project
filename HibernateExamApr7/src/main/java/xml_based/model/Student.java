package xml_based.model;

public class Student {
    private Integer studId;
    private String studName;
    private Integer studRoll;
    private  Integer subId;

    public Student( String studName, Integer studRoll, Integer subId) {

        this.studName = studName;
        this.studRoll = studRoll;
        this.subId = subId;
    }

    public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public Integer getStudRoll() {
        return studRoll;
    }

    public void setStudRoll(Integer studRoll) {
        this.studRoll = studRoll;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }
}

package xml_based.model;

public class Teacher {
    private Integer teacheId;
    private String teacherName;
    private String teacherQualification;
    private Integer expOfTeaching;
    private Integer studentId;

    public Teacher(Integer teacheId, String teacherName, String teacherQualification, Integer expOfTeaching, Integer studentId) {
        this.teacheId = teacheId;
        this.teacherName = teacherName;
        this.teacherQualification = teacherQualification;
        this.expOfTeaching = expOfTeaching;
        this.studentId = studentId;
    }

    public Integer getTeacheId() {
        return teacheId;
    }

    public void setTeacheId(Integer teacheId) {
        this.teacheId = teacheId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherQualification() {
        return teacherQualification;
    }

    public void setTeacherQualification(String teacherQualification) {
        this.teacherQualification = teacherQualification;
    }

    public Integer getExpOfTeaching() {
        return expOfTeaching;
    }

    public void setExpOfTeaching(Integer expOfTeaching) {
        this.expOfTeaching = expOfTeaching;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}

package com.dal.universityPortal.model;

public class UniversityProfile {
    private int universityProfileId;
    private int authenticationId;
    private String universityName;
    private String universityDescription;
    private String universityDepartmentName;
    private int courseId;
    private String courseName1;
    private String courseName2;
    private Boolean winterTermCourse1;
    private Boolean summerTermCourse1;
    private Boolean fallTermCourse1;
    private Boolean winterTermCourse2;
    private Boolean summerTermCourse2;
    private Boolean fallTermCourse2;

    public UniversityProfile(){
    }

    public UniversityProfile(int courseId, String courseName, Boolean winterTerm, Boolean summerTerm, Boolean fallTerm) {
        this.courseId = courseId;
        this.courseName1 = courseName;
        this.winterTermCourse1 = winterTerm;
        this.summerTermCourse1 = summerTerm;
        this.fallTermCourse1 = fallTerm;
    }

    public UniversityProfile(int universityProfileId, int authenticationId, String universityName, String universityDescription, String universityDepartmentName, int courseId, String courseName1, String courseName2, Boolean winterTermCourse1, Boolean summerTermCourse1, Boolean fallTermCourse1, Boolean winterTermCourse2, Boolean summerTermCourse2, Boolean fallTermCourse2) {
        this.universityProfileId = universityProfileId;
        this.authenticationId = authenticationId;
        this.universityName = universityName;
        this.universityDescription = universityDescription;
        this.universityDepartmentName = universityDepartmentName;
        this.courseId = courseId;
        this.courseName1 = courseName1;
        this.courseName2 = courseName2;
        this.winterTermCourse1 = winterTermCourse1;
        this.summerTermCourse1 = summerTermCourse1;
        this.fallTermCourse1 = fallTermCourse1;
        this.winterTermCourse2 = winterTermCourse2;
        this.summerTermCourse2 = summerTermCourse2;
        this.fallTermCourse2 = fallTermCourse2;
    }

    public UniversityProfile(int universityProfileId, int authenticationId, String universityName, String universityDescription, String universityDepartmentName) {
        this.universityProfileId = universityProfileId;
        this.authenticationId = authenticationId;
        this.universityName = universityName;
        this.universityDescription = universityDescription;
        this.universityDepartmentName = universityDepartmentName;
    }

    public int getId() {
        return universityProfileId;
    }

    public void setId(int university_profile_id) {
        this.universityProfileId = university_profile_id;
    }

    public int getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(int authentication_id) {
        this.authenticationId = authentication_id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String university_name) {
        this.universityName = university_name;
    }

    public String getUniversityDescription() {
        return universityDescription;
    }

    public void setUniversityDescription(String university_address) {
        this.universityDescription = university_address;
    }

    public String getUniversityDepartmentName() {
        return universityDepartmentName;
    }

    public void setUniversityDepartmentName(String universityDepartmentName) {
        this.universityDepartmentName = universityDepartmentName;
    }
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName1() {
        return courseName1;
    }

    public void setCourseName1(String courseName1) {
        this.courseName1 = courseName1;
    }

    public Boolean getWinterTermCourse1() {
        return winterTermCourse1;
    }

    public void setWinterTermCourse1(Boolean winterTermCourse1) {
        this.winterTermCourse1 = winterTermCourse1;
    }

    public Boolean getSummerTermCourse1() {
        return summerTermCourse1;
    }

    public void setSummerTermCourse1(Boolean summerTermCourse1) {
        this.summerTermCourse1 = summerTermCourse1;
    }

    public Boolean getFallTermCourse1() {
        return fallTermCourse1;
    }

    public void setFallTermCourse1(Boolean fallTermCourse1) {
        this.fallTermCourse1 = fallTermCourse1;
    }

    public Boolean getWinterTermCourse2() {
        return winterTermCourse2;
    }

    public void setWinterTermCourse2(Boolean winterTermCourse2) {
        this.winterTermCourse2 = winterTermCourse2;
    }

    public Boolean getSummerTermCourse2() {
        return summerTermCourse2;
    }

    public void setSummerTermCourse2(Boolean summerTermCourse2) {
        this.summerTermCourse2 = summerTermCourse2;
    }

    public Boolean getFallTermCourse2() {
        return fallTermCourse2;
    }

    public void setFallTermCourse2(Boolean fallTermCourse2) {
        this.fallTermCourse2 = fallTermCourse2;
    }

    public String getCourseName2() {
        return courseName2;
    }

    public void setCourseName2(String courseName2) {
        this.courseName2 = courseName2;
    }
}
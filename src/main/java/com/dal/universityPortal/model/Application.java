package com.dal.universityPortal.model;

public class Application {

    private int university_course_id;
    private String sop;
    private String status;
    private int processed_by;
    private String comment;
    private String course_name;
    private Boolean winterTermCourse;
    private Boolean summerTermCourse;
    private Boolean fallTermCourse;
    private int student_profile_id;

    private String degree_name;
    private String grade;
    private String start_date;
    private String end_date;
    private int authenticationId;

    private String first_name;
    private String last_name;
    private String address;
    private String mobile_number;
    private String email_address;

    public Application(){
        
    }
    
    public Application(int university_course_id, String sop, String status, int processed_by, String comment,
            String course_name, Boolean winterTermCourse, Boolean summerTermCourse, Boolean fallTermCourse,
            int student_profile_id, String degree_name, String grade, String start_date, String end_date,
            int authenticationId, String first_name, String last_name, String address, String mobile_number,
            String email_address) {
        this.university_course_id = university_course_id;
        this.sop = sop;
        this.status = status;
        this.processed_by = processed_by;
        this.comment = comment;
        this.course_name = course_name;
        this.winterTermCourse = winterTermCourse;
        this.summerTermCourse = summerTermCourse;
        this.fallTermCourse = fallTermCourse;
        this.student_profile_id = student_profile_id;
        this.degree_name = degree_name;
        this.grade = grade;
        this.start_date = start_date;
        this.end_date = end_date;
        this.authenticationId = authenticationId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.mobile_number = mobile_number;
        this.email_address = email_address;
    }



    public int getUniversity_course_id() {
        return university_course_id;
    }

    public void setUniversity_course_id(int university_course_id) {
        this.university_course_id = university_course_id;
    }

    public int getStudent_profile_id() {
        return student_profile_id;
    }

    public void setStudent_profile_id(int student_profile_id) {
        this.student_profile_id = student_profile_id;
    }

    public String getSop() {
        return sop;
    }

    public void setSop(String sop) {
        this.sop = sop;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProcessed_by() {
        return processed_by;
    }

    public void setProcessed_by(int processed_by) {
        this.processed_by = processed_by;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }    

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Boolean getWinterTermCourse() {
        return winterTermCourse;
    }

    public void setWinterTermCourse(Boolean winterTermCourse) {
        this.winterTermCourse = winterTermCourse;
    }

    public Boolean getSummerTermCourse() {
        return summerTermCourse;
    }

    public void setSummerTermCourse(Boolean summerTermCourse) {
        this.summerTermCourse = summerTermCourse;
    }

    public Boolean getFallTermCourse() {
        return fallTermCourse;
    }

    public void setFallTermCourse(Boolean fallTermCourse) {
        this.fallTermCourse = fallTermCourse;
    }

    public String getDegree_name() {
        return degree_name;
    }

    public void setDegree_name(String degree_name) {
        this.degree_name = degree_name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(int authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

}

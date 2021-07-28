package com.dal.universityPortal.model;

public class Application {

    private int appId;
    private int programId;
    private int studentId;
    private String status;
    private String sop;
    private int processedBy;
    private String comment;

    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String emailId;

    private String highestEducation;
    private String grades;
    private String startDate;
    private String endDate;

    public Application(){
    }

    public Application(int appId, int programId, int studentId, String status, int processedBy, String comment, String firstName, String lastName, String address, String mobileNumber, String emailId, String highestEducation, String grades, String startDate, String endDate, String sop) {
        this.appId = appId;
        this.programId = programId;
        this.studentId = studentId;
        this.status = status;
        this.processedBy = processedBy;
        this.comment = comment;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.highestEducation = highestEducation;
        this.grades = grades;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sop = sop;
    }

    public int getAppId() { return appId; }

    public void setAppId(int appId) { this.appId = appId; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) { this.address = address; }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSop() {
        return sop;
    }

    public void setSop(String sop) {
        this.sop = sop;
    }

    public int getProgramId() { return programId; }

    public void setProgramId(int programId) { this.programId = programId; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public int getProcessedBy() { return processedBy; }

    public void setProcessedBy(int processedBy) { this.processedBy = processedBy; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public int getStudentId() { return studentId; }

    public void setStudentId(int studentId) { this.studentId = studentId; }
}

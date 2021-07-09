package com.dal.universityPortal.model;

public class UniversityCourse {
    private int universityCourseId;
    private int universityId;
    private int courseId;

    public UniversityCourse() {
    }

    public UniversityCourse(int universityCourseId, int universityId, int courseId) {
        this.universityCourseId = universityCourseId;
        this.universityId = universityId;
        this.courseId = courseId;
    }

    public int getUniversityCourseId() {
        return universityCourseId;
    }

    public void setUniversityCourseId(int universityCourseId) {
        this.universityCourseId = universityCourseId;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}

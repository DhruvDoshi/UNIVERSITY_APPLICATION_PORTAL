package com.dal.UniversityPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "university_profile")
public class university_profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int university_profile_id;

    @Column(name = "authentication_id")
    private int authentication_id;

    @Column(name = "university_name")
    private String university_name;

    @Column(name = "university_address")
    private String university_address;

    @Column(name = "department_name")
    private String department_name;

    public int getId() {
        return university_profile_id;
    }

    public void setId(int university_profile_id) {
        this.university_profile_id = university_profile_id;
    }

    public int getAuthenticationId() {
        return authentication_id;
    }

    public void setAuthenticationId(int authentication_id) {
        this.authentication_id = authentication_id;
    }

    public String getUniversityName() {
        return university_name;
    }

    public void setUniversityName(String university_name) {
        this.university_name = university_name;
    }

    public String getUniversityAddress() {
        return university_address;
    }

    public void setUniversityAddress(String university_address) {
        this.university_address = university_address;
    }

    public String getDepartmentName() {
        return department_name;
    }

    public void setDepartmentName(String department_name) {
        this.department_name = department_name;
    }
}
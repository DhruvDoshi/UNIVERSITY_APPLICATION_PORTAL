package com.dal.universityPortal.service;

import java.sql.SQLException;

import com.dal.universityPortal.database.DBSession;
import com.dal.universityPortal.model.Application;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ApplyingUniversityServiceImpl implements ApplyingUniversityService{

    @Override
    public void saveApplication(Application application) throws SQLException {
        try(DBSession dbSession = new DBSession();) {
            int authentication_id=1;
            dbSession.execute("INSERT INTO student_profile (authentication_id,first_name,last_name,address,mobile_number,email_address) VALUE (" + authentication_id + ", \"" + application.getFirst_name() + "\", \"" + application.getLast_name() + "\" , \"" + application.getAddress() + "\", \"" + application.getMobile_number() + "\", \"" + application.getEmail_address() + "\");");
            List<Map<String, Object>> sp = dbSession.fetch("SELECT * FROM student_profile WHERE authentication_id=?",Arrays.asList(authentication_id));
            application.setStudent_profile_id((int)sp.get(0).get("student_profile_id"));
            dbSession.execute("INSERT INTO student_education (student_profile_id,degree_name,grade,start_date,end_date) VALUE (" + (int)sp.get(0).get("student_profile_id") + ", \"" + application.getDegree_name() + "\", \"" + application.getGrade() + "\" , \"" + application.getStart_date() + "\", \"" + application.getEnd_date() + "\");");
            List<Map<String, Object>> course = dbSession.fetch("SELECT * FROM course WHERE course_name = ?",Arrays.asList(application.getCourse_name()));
            List<Map<String, Object>> university_course = dbSession.fetch("SELECT * FROM university_course WHERE course_id = ?",Arrays.asList(course.get(0).get("course_id")));
            dbSession.execute("INSERT INTO application (university_course_id, student_profile_id, sop) VALUE ("+(int)university_course.get(0).get("university_course_id")+", \""+ (int)sp.get(0).get("student_profile_id")+", \""+ application.getSop()+"\");");
        }
        
    }

    
}

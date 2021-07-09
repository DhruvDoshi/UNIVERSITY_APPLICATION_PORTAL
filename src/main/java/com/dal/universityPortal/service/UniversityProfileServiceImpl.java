package com.dal.universityPortal.service;

import com.dal.universityPortal.database.DBSession;
import com.dal.universityPortal.model.UniversityProfile;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class UniversityProfileServiceImpl implements UniversityProfileService{

    @Override
    public void saveProfile(UniversityProfile universityProfile) throws SQLException {
        try(DBSession dbSession = new DBSession();) {
            int authentication_id=1;
            dbSession.execute("SET FOREIGN_KEY_CHECKS=OFF;");
            dbSession.execute("INSERT INTO university_profile (authentication_id,university_name,university_description,department_name) VALUE (" + authentication_id + ", \"" + universityProfile.getUniversityName() + "\", \"" + universityProfile.getUniversityDescription() + "\" , \"" + universityProfile.getUniversityDepartmentName() + "\");");
            dbSession.execute("INSERT INTO course (course_name,winter_term,summer_term,fall_term) VALUES (?,?,?,?)",Arrays.asList(universityProfile.getCourseName1(), universityProfile.getWinterTermCourse1(),universityProfile.getSummerTermCourse1(),universityProfile.getFallTermCourse1()));
            dbSession.execute("INSERT INTO course (course_name,winter_term,summer_term,fall_term) VALUES (?,?,?,?)",Arrays.asList(universityProfile.getCourseName2(), universityProfile.getWinterTermCourse2(),universityProfile.getSummerTermCourse2(),universityProfile.getFallTermCourse2()));
            List<Map<String, Object>> universities = dbSession.fetch("SELECT * from university_profile");
            List<Map<String, Object>> courses = dbSession.fetch("SELECT * from course");

            dbSession.execute("INSERT INTO university_course (university_id,course_id) VALUES (?,?)",Arrays.asList(universities.get(universities.size()-1).get("university_profile_id"),courses.get(courses.size()-2).get("course_id")));
            dbSession.execute("INSERT INTO university_course (university_id,course_id) VALUES (?,?)",Arrays.asList(universities.get(universities.size()-1).get("university_profile_id"),courses.get(courses.size()-1).get("course_id")));
        }
    }
}

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

    @Override
    public UniversityProfile readProfile() throws SQLException {
        try(DBSession dbSession = new DBSession();) {
            int authentication_id=1;
            UniversityProfile universityProfile;
            List<Map<String, Object>> university = dbSession.fetch("SELECT * from university_profile where authentication_id = ?", Arrays.asList(authentication_id));

            if(university.isEmpty()){
                universityProfile= new UniversityProfile(0,0,"","","",0,"","",false,false,false,false,false,false);
            }
            else{
                List<Map<String, Object>> university_course = dbSession.fetch("SELECT * from university_course where university_id =?",Arrays.asList(university.get(0).get("university_profile_id")));
                List<Map<String, Object>> course1 = dbSession.fetch("SELECT * from course where course_id =?",Arrays.asList(university_course.get(0).get("course_id")));
                List<Map<String, Object>> course2 = dbSession.fetch("SELECT * from course where course_id =?",Arrays.asList(university_course.get(1).get("course_id")));
                System.out.println((int)course1.get(0).get("fall_term")==0);
                universityProfile= new UniversityProfile((Integer) university.get(0).get("university_profile_id"),authentication_id,(String) university.get(0).get("university_name"),(String) university.get(0).get("university_description"),(String) university.get(0).get("department_name"),0, (String) course1.get(0).get("course_name"),(String) course2.get(0).get("course_name"), (int) course1.get(0).get("winter_term")==0,(int) course1.get(0).get("summer_term")==0,(int) course1.get(0).get("fall_term")==0,(int) course2.get(0).get("winter_term")==0,(int) course2.get(0).get("summer_term")==0,(int) course2.get(0).get("fall_term")==0);
            }
            return universityProfile;
        }
    }
}

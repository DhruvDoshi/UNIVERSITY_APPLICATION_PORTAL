package com.dal.universityPortal.service;

import com.dal.universityPortal.database.DBSession;
import com.dal.universityPortal.model.UniversityProfile;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class SearchUniversityServiceImpl implements SearchUniversityService {

    @Override
    public UniversityProfile getUniversityDetails(UniversityProfile universityProfile) throws SQLException {
        try(DBSession dbSession = new DBSession();) {
            List<Map<String, Object>> universityDetails = dbSession.fetch("SELECT * FROM university_profile WHERE university_name = ?", Arrays.asList(universityProfile.getUniversityName()));

            if(universityDetails.isEmpty()){
                universityProfile= new UniversityProfile(0, 0, "", "","",0, "", "", false, false, false, false, false, false);
            } else {
                List<Map<String, Object>> universityCourses =
                        dbSession.fetch("SELECT * FROM university_course WHERE university_id =?", Arrays.asList(universityDetails.get(0).get("university_profile_id")));
                List<Map<String, Object>> course1 = dbSession.fetch("SELECT * from course where course_id =?", Arrays.asList(universityCourses.get(0).get("course_id")));
                List<Map<String, Object>> course2 = dbSession.fetch("SELECT * from course where course_id =?", Arrays.asList(universityCourses.get(1).get("course_id")));
                universityProfile = new UniversityProfile((Integer) universityDetails.get(0).get("university_profile_id"), (Integer) universityDetails.get(0).get("authentication_id"), (String) universityDetails.get(0).get("university_name"), (String) universityDetails.get(0).get("university_description"), (String) universityDetails.get(0).get("department_name"), 0, (String) course1.get(0).get("course_name"), (String) course2.get(0).get("course_name"), (Integer) course1.get(0).get("winter_term") != 0, (Integer) course1.get(0).get("summer_term") != 0, (Integer) course1.get(0).get("fall_term") != 0, (Integer) course2.get(0).get("winter_term") != 0, (Integer) course2.get(0).get("summer_term") != 0, (Integer) course2.get(0).get("fall_term") != 0);
            }
            return universityProfile;
        }
    }
}

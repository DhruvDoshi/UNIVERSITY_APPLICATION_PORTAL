package com.dal.universityPortal.database;

import com.dal.universityPortal.model.Application;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.dal.universityPortal.database.query.ApplicationQuery.*;
import static com.dal.universityPortal.database.query.PaymentQuery.FOREIGN_KEY_CHECKS;

public class ApplicationDao implements Dao<Application> {

    @Override
    public List<Application> fetchAll() throws SQLException {
        return null;
    }
    public Application fetchAllByParam(int id) throws SQLException {
        List<Map<String, Object>> applicationlist;
        Application application = new Application();
        try(DBSession dbSession = new DBSession()){
            applicationlist=dbSession.fetch(FETCH_ALL_APPLICATION);
            dbSession.setAutoCommit(true);
            for (Map<String, Object> applist: applicationlist){
                List<Map<String, Object>> student = dbSession.fetch(FETCH_STUDENT_BY_ID+id);
                List<Map<String, Object>> user = dbSession.fetch(FETCH_USER_BY_ID+id);
                List<Map<String, Object>> education = dbSession.fetch(FETCH_EDUCATION_BY_ID+id);

                // From Application Table
                application.setApplication_id(Integer.parseInt(String.valueOf(applist.get("id"))));
                application.setProgram_id(Integer.parseInt(String.valueOf(applist.get("program_id"))));
                application.setStudent_id(Integer.parseInt(String.valueOf(applist.get("student_id"))));
                application.setSop(String.valueOf(applist.get("sop")));
                application.setStatus(String.valueOf(applist.get("status")));
                application.setProcessed_by(Integer.parseInt(String.valueOf(applist.get("processed_by"))));
                application.setComment(String.valueOf(applist.get("comment")));

                //From Student and User Table
                application.setFirst_name(String.valueOf(student.get(0).get("first_name")));
                application.setLast_name(String.valueOf(student.get(0).get("last_name")));
                application.setAddress(String.valueOf(student.get(0).get("address")));
                application.setMobile_number(String.valueOf(student.get(0).get("mobile_number")));
                application.setEmail_id(String.valueOf(user.get(0).get("email")));

                //From Education Table
                application.setHighest_education(String.valueOf(education.get(0).get("name")));
                application.setGrades(String.valueOf(education.get(0).get("outcome")));
                application.setStart_date(String.valueOf(education.get(0).get("start_date")));
                application.setEnd_date(String.valueOf(education.get(0).get("end_date")));
            }
        }
        return application;
    }
    @Override
    public void insert(Application application) throws SQLException {
        int program_id=1;
        int student_id=1;
        String status ="Under Review";
        int processed_by = 2;
        String comment="Bad";
        String outcome_type="90%";
        try(DBSession dbSession = new DBSession()){
            dbSession.execute(FOREIGN_KEY_CHECKS);
            dbSession.execute(INSERT_APPLICATION, Arrays.asList(program_id,student_id,application.getSop(),
                    status,processed_by,comment));
            dbSession.execute(INSERT_EDUCATION,Arrays.asList(student_id,application.getHighest_education(),
                    application.getGrades(),outcome_type,application.getStart_date(),application.getEnd_date()));
        }

    }

    @Override
    public void update(Application application) throws SQLException {

    }

    @Override
    public void delete(Application application) throws SQLException {

    }
}

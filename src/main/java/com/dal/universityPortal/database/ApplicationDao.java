package com.dal.universityPortal.database;

import com.dal.universityPortal.model.Application;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.dal.universityPortal.database.query.ApplicationQuery.*;
import static com.dal.universityPortal.database.query.PaymentQuery.FOREIGN_KEY_CHECKS;

public class ApplicationDao implements InsertDao<Application>{

    public Application fetchAllByParam(int id) throws SQLException {
        List<Map<String, Object>> applicationlist;
        Application application = new Application();
        try(DBSession dbSession = new DBSession()){
            applicationlist=dbSession.fetch(FETCH_ALL_APPLICATION);
            dbSession.setAutoCommit(true);
            for (Map<String, Object> applist: applicationlist){
                // From Application Table
                application.setApplication_id(Integer.parseInt(String.valueOf(applist.get("id"))));
            }
        }
        return application;
    }

    @Override
    public void insert(Application application) throws SQLException {
        int program_id=application.getProgram_id();
        int student_id=application.getStudent_id();
        String status ="Pending";
        int processed_by = 0;
        String comment="";
        String outcome_type="Grade";
        try(DBSession dbSession = new DBSession()){
            dbSession.execute(FOREIGN_KEY_CHECKS);
            dbSession.execute(INSERT_APPLICATION, Arrays.asList(program_id,student_id,application.getSop(),
                    status,processed_by,comment));
            dbSession.execute(INSERT_EDUCATION,Arrays.asList(student_id,application.getHighest_education(),
                    application.getGrades(),outcome_type,application.getStart_date(),application.getEnd_date()));
        }

    }
}

package com.dal.universityPortal.database;

import com.dal.universityPortal.model.Application;
import com.dal.universityPortal.model.Program;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.dal.universityPortal.database.query.ApplicationQuery.FETCH_ALL_APPLICATION;

public class ApplicationDao implements Dao<Application> {

    public Application fetchAllByParam(int id) throws SQLException {
        List<Map<String, Object>> applicationlist;
        Application application = new Application();
        try(DBSession dbSession = new DBSession()){
            applicationlist=dbSession.fetch(FETCH_ALL_APPLICATION);
            dbSession.setAutoCommit(true);
            for (Map<String, Object> applist: applicationlist){
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
        String query1;
        String query2;
        try(DBSession dbSession = new DBSession()){
            dbSession.execute("SET FOREIGN_KEY_CHECKS=OFF;");
            query1 = "INSERT INTO application (program_id, student_id, sop, status, processed_by, comment) VALUE ("+
                    program_id+","+student_id+",\""+application.getSop()+"\",\""+status+"\","+processed_by+",\""+comment+"\");";
            System.out.println(query1);
            dbSession.execute(query1);
            query2 = "INSERT INTO education (student_id, name, outcome, outcome_type, start_date, end_date) VALUE ("+
                    student_id+",\""+application.getHighest_education()+"\",\""+application.getGrades()+"\",\""+outcome_type+"\",\""+
                    application.getStart_date()+"\",\""+application.getEnd_date()+"\");";
            System.out.println(query2);
            dbSession.execute(query2);
        }

    }
}

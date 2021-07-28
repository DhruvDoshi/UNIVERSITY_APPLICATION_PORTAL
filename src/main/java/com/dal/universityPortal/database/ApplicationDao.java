package com.dal.universityPortal.database;

import com.dal.universityPortal.model.Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.dal.universityPortal.constant.ApplicationConstant.*;
import static com.dal.universityPortal.database.query.ApplicationQuery.*;

public class ApplicationDao implements InsertDao<Application> {

    public Application fetchAllByParam(int id) throws SQLException {
        List<Map<String, Object>> applicationlist;
        Application application = new Application();
        try (DBSession dbSession = new DBSession()) {
            applicationlist = dbSession.fetch(String.format(FETCH_APPLICATION_BY_ID_QUERY, id));
            for (Map<String, Object> applist : applicationlist) {
                application.setApplicationId(Integer.parseInt(String.valueOf(applist.get("id"))));
            }
        }
        return application;
    }

    @Override
    public void insert(Application application) throws SQLException {
        int program_id = application.getProgramId();
        int student_id = application.getStudentId();
        try (DBSession dbSession = new DBSession()) {
            dbSession.execute(FOREIGN_KEY_CHECKS);
            dbSession.execute(INSERT_APPLICATION, Arrays.asList(program_id, student_id, application.getSop(), APPLICATION_STATUS, APPLICATION_PROCESSED_BY, ""));
            dbSession.execute(INSERT_EDUCATION, Arrays.asList(student_id, application.getHighestEducation(), application.getGrades(), APPLICATION_OUTCOME_TYPE, application.getStartDate(), application.getEndDate()));
        }
    }
}

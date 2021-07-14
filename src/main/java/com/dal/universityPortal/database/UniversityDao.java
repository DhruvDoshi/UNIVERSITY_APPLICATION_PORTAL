package com.dal.universityPortal.database;

import com.dal.universityPortal.model.Program;
import com.dal.universityPortal.model.University;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UniversityDao implements Dao<University> {
    @Override
    public List<University> fetchAll() throws SQLException {
        return null;
    }


    @Override
    public void insert(University university) throws SQLException {
        try(DBSession dbSession = new DBSession()) {
            dbSession.execute("INSERT INTO university (user_id,university_name,university_description) VALUES (?,?,?)", Arrays.asList(university.getUserId(), university.getUniversityName(),
                    university.getUniversityDescription()));
        }
    }

    @Override
    public void update(University university) throws SQLException {
    }

    @Override
    public void delete(University university) {

    }
}

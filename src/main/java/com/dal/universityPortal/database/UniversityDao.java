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
        List<Map<String, Object>> uniList;
        List<University> universityList = new ArrayList<>();
        try(DBSession dbSession = new DBSession()) {
            uniList=dbSession.fetch("SELECT * from university");
            dbSession.setAutoCommit(true);
            for (Map<String, Object> mapUni : uniList) {
                University university = new University();
                university.setUserId(Integer.parseInt(String.valueOf(mapUni.get("user_id"))));
                university.setUniversityName(String.valueOf(mapUni.get("university_name")));
                university.setUniversityDescription(String.valueOf(mapUni.get("university_description")));
                universityList.add(university);
            }
        }
        return universityList;
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
        try(DBSession dbSession = new DBSession()) {
            System.out.println(university.getUniversityName());
            String query = "UPDATE university SET university_name = '"+university.getUniversityName()+"', university_description = '"+university.getUniversityDescription()+"' WHERE user_id = "+university.getUserId();
            System.out.println(query);
            dbSession.execute(query);
        }
    }

    @Override
    public void delete(University university) {

    }
}

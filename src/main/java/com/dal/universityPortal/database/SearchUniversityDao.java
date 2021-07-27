package com.dal.universityPortal.database;

import com.dal.universityPortal.model.Program;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SearchUniversityDao implements Dao<Program> {

    @Override
    public List<Program> fetchAll() throws SQLException {
        List<Map<String, Object>> universityDetail;
        List<Program> universityDetails = new ArrayList<>();
        try (DBSession dbSession = new DBSession()) {
            universityDetail = dbSession.fetch("SELECT * FROM university");
            for (Map<String, Object> mapUniversity : universityDetail) {
                Program universityData = new Program();
                universityData.setUserId(Integer.parseInt(String.valueOf(mapUniversity.get("user_id"))));
                universityData.setUniversityName(String.valueOf(mapUniversity.get("university_name")));
                universityData.setUniversityDescription(String.valueOf(mapUniversity.get("university_description")));
                universityDetails.add(universityData);
            }
        }
        return universityDetails;
    }

    public List<Program> fetchAllByParams(int id) throws SQLException {
        List<Map<String, Object>> programDetail;
        List<Program> programDetails = new ArrayList<>();
        try (DBSession dbSession = new DBSession()) {
            programDetail = dbSession.fetch("SELECT * FROM program WHERE university_id = ?", Arrays.asList(id));
            for (Map<String, Object> mapProgram : programDetail) {
                Program program = new Program();
                program.setId(Integer.parseInt(String.valueOf(mapProgram.get("id"))));
                program.setName(String.valueOf(mapProgram.get("name")));
                programDetails.add(program);
            }
            return programDetails;
        }
    }

    @Override
    public void insert(Program program) {

    }

    @Override
    public void update(Program program) {
    }

    @Override
    public void delete(Program program) {

    }
}

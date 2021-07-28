package com.dal.universityPortal.database;

import com.dal.universityPortal.model.Program;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ApplicationStatusDao {

    public Program fetchAllByParam(int id) throws SQLException {
        List<Map<String, Object>> programList;
        Program program = new Program();
        try (DBSession dbSession = new DBSession()) {
            programList = dbSession.fetch("SELECT * from program where id = ?", Arrays.asList(id));
            for (Map<String, Object> mapProgram : programList) {
                program.setId(Integer.parseInt(String.valueOf(mapProgram.get("id"))));
                program.setUniversityId(Integer.parseInt(String.valueOf(mapProgram.get("university_id"))));
                program.setName(String.valueOf(mapProgram.get("name")));
            }
        }
        return program;
    }
}

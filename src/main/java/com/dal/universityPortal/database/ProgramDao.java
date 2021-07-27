package com.dal.universityPortal.database;

import com.dal.universityPortal.model.Program;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProgramDao implements Dao<Program> {

    @Override
    public List<Program> fetchAll() throws SQLException {
        List<Map<String, Object>> programList;
        List<Program> programs = new ArrayList<>();
        try (DBSession dbSession = new DBSession()) {
            programList = dbSession.fetch("SELECT * from program");
            for (Map<String, Object> mapProgram : programList) {
                Program program = new Program();
                program.setAmount(Integer.parseInt(String.valueOf(mapProgram.get("amount"))));
                programs.add(program);
            }
        }
        return programs;
    }

    public List<Program> fetchAllByParam(int id) throws SQLException {
        List<Map<String, Object>> programList;
        List<Program> programs = new ArrayList<>();
        try (DBSession dbSession = new DBSession()) {
            programList = dbSession.fetch("SELECT * from program where university_id = ?", Arrays.asList(id));
            for (Map<String, Object> mapProgram : programList) {
                Program program = new Program();
                program.setId(Integer.parseInt(String.valueOf(mapProgram.get("id"))));
                program.setUniversityId(Integer.parseInt(String.valueOf(mapProgram.get("university_id"))));
                program.setName(String.valueOf(mapProgram.get("name")));
                programs.add(program);
            }
        }
        return programs;
    }

    @Override
    public void insert(Program program) throws SQLException {
        try (DBSession dbSession = new DBSession()) {
            dbSession.execute("SET FOREIGN_KEY_CHECKS=OFF;");
            dbSession.setAutoCommit(false);
            dbSession.execute("INSERT INTO program (name,university_id) VALUES (?,?)", Arrays.asList(program.getName(),
                    program.getUniversityId()));
            dbSession.setAutoCommit(true);
        }
    }

    @Override
    public void update(Program program) {

    }

    @Override
    public void delete(Program program1) throws SQLException {
        try (DBSession dbSession = new DBSession()) {
            String query = "DELETE FROM program WHERE university_id="+program1.getUniversityId()+" AND name="+"'"+program1.getName()+"'";
            dbSession.execute(query);
        }
    }
}

package com.dal.universityPortal.service;

import com.dal.universityPortal.database.ProgramDao;
import com.dal.universityPortal.model.Program;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService{

    ProgramDao programDao= new ProgramDao();

    @Override
    public Boolean saveProgram(Program program) throws SQLException {
        try {
            programDao.insert(program);
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return true;
    }

    @Override
    public List<Program> readProgram(int id) throws SQLException {
        return programDao.fetchAllByParam(id);
    }

    @Override
    public void deleteProgram(int id,String name) throws SQLException {
        Program program = new Program(name,id);
        programDao.delete(program);
    }
}

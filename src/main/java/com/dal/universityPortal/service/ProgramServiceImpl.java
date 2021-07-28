package com.dal.universityPortal.service;

import com.dal.universityPortal.database.ProgramDao;
import com.dal.universityPortal.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService{

    @Autowired
    private ProgramDao programDao;

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
        return programDao.fetchAllByUniversityId(id);
    }

    @Override
    public void deleteProgram(Program program) throws SQLException {
        programDao.delete(program);
    }
}

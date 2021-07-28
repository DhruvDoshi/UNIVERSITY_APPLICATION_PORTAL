package com.dal.universityPortal.service;

import com.dal.universityPortal.database.ProgramDao;
import com.dal.universityPortal.model.Program;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService{
    Logger logger = LogManager.getLogger(ProgramServiceImpl.class);

    ProgramDao programDao= new ProgramDao();

    @Override
    public Boolean saveProgram(Program program) {
        try {
            programDao.insert(program);
        } catch (SQLException exception) {
            logger.error(exception);
        }
        return true;
    }

    @Override
    public List<Program> readProgram(int id) throws SQLException {
        return programDao.fetchAllByParam(id);
    }

    @Override
    public void deleteProgram(Program program) throws SQLException {
        programDao.delete(program);
    }
}

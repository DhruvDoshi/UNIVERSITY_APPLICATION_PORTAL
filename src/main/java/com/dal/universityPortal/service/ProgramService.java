package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Program;
import com.dal.universityPortal.model.University;

import java.sql.SQLException;
import java.util.List;

public interface ProgramService {
    Boolean saveProgram(Program program) throws SQLException;
    List<Program> readProgram(int id) throws SQLException;
    void deleteProgram(int id,String name) throws SQLException;
}

package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Program;

import java.sql.SQLException;
import java.util.List;

public interface SearchUniversityService {

    Program getUniversityDetails(Program program) throws SQLException;
    List<Program> getProgramDetails(int id) throws SQLException;
}

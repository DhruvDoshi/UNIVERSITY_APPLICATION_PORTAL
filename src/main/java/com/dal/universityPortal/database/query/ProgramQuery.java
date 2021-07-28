package com.dal.universityPortal.database.query;

public class ProgramQuery {

    public static final String FETCH_ALL_PROGRAMS = "SELECT * from program";
    public static final String FETCH_PROGRAMS_BY_APPLICATION_ID = "SELECT * from program where id = ?";
    public static final String FETCH_PROGRAMS_BY_UNIVERSITY_ID = "SELECT * from program where university_id = ?";
    public static final String SET_FOREIGN_CHECKS_OFF = "SET FOREIGN_KEY_CHECKS=OFF;";
    public static final String INSERT_INTO_PROGRAM = "INSERT INTO program (name,university_id) VALUES (?,?)";
}

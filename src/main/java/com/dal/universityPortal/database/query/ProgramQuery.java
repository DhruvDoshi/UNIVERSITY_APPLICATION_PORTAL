package com.dal.universityPortal.database.query;

public class ProgramQuery {
    public static final String FETCH_ALL_PROGRAMS = "SELECT * from program";
    public static final String FETCH_PROGRAMS_BY_UNIVERSITY_ID = "SELECT * from program where id = ?";
}
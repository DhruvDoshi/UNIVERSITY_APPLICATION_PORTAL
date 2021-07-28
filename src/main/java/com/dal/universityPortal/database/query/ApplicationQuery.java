package com.dal.universityPortal.database.query;

public class ApplicationQuery {
    public static final String FETCH_APPLICATION_BY_ID_QUERY = "SELECT * FROM application WHERE student_id = %s";
    public static final String FOREIGN_KEY_CHECKS = "SET FOREIGN_KEY_CHECKS=OFF;";
    public static String FETCH_ALL_APPLICATION = "SELECT * FROM application;";
    public static String INSERT_APPLICATION = "INSERT INTO application (program_id, student_id, sop, status, processed_by, comment) VALUES (?,?,?,?,?,?)";
    public static String INSERT_EDUCATION = "INSERT INTO education (student_id, name, outcome, outcome_type, start_date, end_date) VALUES (?,?,?,?,?,?)";
}

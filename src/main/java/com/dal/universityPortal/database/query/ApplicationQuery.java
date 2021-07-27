package com.dal.universityPortal.database.query;

public class ApplicationQuery {
    public static final String FETCH_APPLICATION_BY_ID_QUERY = "SELECT * FROM application WHERE student_id = %s";
}

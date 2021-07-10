package com.dal.universityPortal.database.query;

public class UserQuery {
    public static final String INSERT_USER_QUERY = "INSERT INTO authentication (username, email, password, type, status) " +
            "VALUES (?, ?, ?, ?, ?)";
}

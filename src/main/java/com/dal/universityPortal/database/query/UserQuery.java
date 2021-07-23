package com.dal.universityPortal.database.query;

public class UserQuery {
    public static final String INSERT_USER_QUERY = "INSERT INTO user (username, email, password, type, status) " +
            "VALUES (?, ?, ?, ?, ?)";
    public static final String FETCH_USER_USING_USERNAME = "SELECT * FROM user WHERE username=?";
}

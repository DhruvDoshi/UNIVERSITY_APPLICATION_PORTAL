package com.dal.universityPortal.database;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    List<T> fetchAll();
    void insert(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(T t) throws SQLException;
}

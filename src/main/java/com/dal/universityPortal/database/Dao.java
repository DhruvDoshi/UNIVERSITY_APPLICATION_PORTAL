package com.dal.universityPortal.database;

import java.util.List;

public interface Dao<T> {
    List<T> fetchAll();
    void insert(T t);
    void update(T t);
    void delete(T t);
}

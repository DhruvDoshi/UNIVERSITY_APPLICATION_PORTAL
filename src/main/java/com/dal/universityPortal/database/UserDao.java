package com.dal.universityPortal.database;

import com.dal.universityPortal.model.User;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.dal.universityPortal.database.query.UserQuery.*;
import static java.util.Objects.isNull;

@Component
public class UserDao implements Dao<User> {
    @Override
    public List<User> fetchAll() {
        return null; //TODO: Implement
    }

    public User fetchOne(String username) throws SQLException {
        Map<String, Object> row;
        User user = null;
        try(DBSession dbSession = new DBSession()) {
            List<Map<String, Object>> rows = dbSession.fetch(FETCH_USER_USING_USERNAME, Arrays.asList(username));
            if(rows.size() > 0) {
                row = rows.get(0);
                user = new User(row);
            }
        }
        return user;
    }

    @Override
    public void insert(User user) throws SQLException {
        try(DBSession dbSession = new DBSession()) {
            dbSession.execute(INSERT_USER_QUERY, Arrays.asList(user.getUsername(), user.getEmail(),
                    user.getPassword(), user.getType(), user.getStatusString()));
        }
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public void delete(User user) throws SQLException {

    }
}

package com.dal.universityPortal.database;

import com.dal.universityPortal.model.User;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static com.dal.universityPortal.database.query.UserQuery.*;

@Component
public class UserDao implements Dao<User> {
    @Override
    public List<User> fetchAll() {
        return null; //TODO: Implement
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

package com.dal.universityPortal.service;

import com.dal.universityPortal.database.DBSession;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class AdminPanelServiceImpl implements AdminPanelService{

    @Override
    public List< Map<String, Object> > getPendingStatusUniversities() throws SQLException {
        try(DBSession dbSession = new DBSession();) {
            List<Map<String, Object>> universities = dbSession.fetch("SELECT * from authentication WHERE type = ? AND status Is Null OR status = ''", Arrays.asList("university"));
        return universities;
        }
    }

    @Override
    public boolean allowUniversityById(int id) throws SQLException {
        try(DBSession dbSession = new DBSession();) {
            dbSession.execute("UPDATE authentication SET status = ? WHERE authentication_id = ?;", Arrays.asList("allow", id));
        }
        return true;
    }

    @Override
    public boolean denyUniversityById(int id) throws SQLException {
        try(DBSession dbSession = new DBSession();) {
            dbSession.execute("UPDATE authentication SET status = ? WHERE authentication_id = ?;", Arrays.asList("deny", id));
        }
        return true;
    }
}

package com.dal.universityPortal.database;

import com.dal.universityPortal.model.AdminPanel;
import com.dal.universityPortal.model.UserStatus;
import com.dal.universityPortal.model.UserType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AdminDao implements SelectDao<AdminPanel>,UpdateDao<AdminPanel> {

    Logger logger = LogManager.getLogger(AdminDao.class);

    @Override
    public List<AdminPanel> fetchAll() throws SQLException {
        List<Map<String, Object>> listUniversities;
        List<AdminPanel> universityList = new ArrayList<>();
        try (DBSession dbSession = new DBSession()) {
            listUniversities = dbSession.fetch("SELECT * FROM user WHERE type = ? AND status = ?", Arrays.asList(UserType.UNIVERSITY.toString(), UserStatus.PENDING.toString()));
            dbSession.setAutoCommit(true);
            for (Map<String, Object> mapUniversities : listUniversities) {
                AdminPanel adminPanel = new AdminPanel();
                adminPanel.setUserId(Integer.parseInt(String.valueOf(mapUniversities.get("id"))));
                adminPanel.setUsername(String.valueOf(mapUniversities.get("username")));
                adminPanel.setEmail(String.valueOf(mapUniversities.get("email")));
                adminPanel.setType(String.valueOf(mapUniversities.get("type")));
                adminPanel.setStatus(String.valueOf(mapUniversities.get("status")));
                universityList.add(adminPanel);
            }
        }
        return universityList;
    }

    @Override
    public void update(AdminPanel adminPanel) {
        try (DBSession dbSession = new DBSession()) {
            dbSession.execute("UPDATE user SET status = ? WHERE id = ?", Arrays.asList(adminPanel.getStatus(), adminPanel.getUserId()));
        } catch (SQLException exception) {
            logger.error(exception);
        }
    }

}

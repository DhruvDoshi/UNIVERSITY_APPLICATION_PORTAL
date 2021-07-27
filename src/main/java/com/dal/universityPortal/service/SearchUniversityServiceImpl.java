
package com.dal.universityPortal.service;

import com.dal.universityPortal.database.SearchUniversityDao;
import com.dal.universityPortal.model.Program;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class SearchUniversityServiceImpl implements SearchUniversityService {

    SearchUniversityDao searchUniversityDao = new SearchUniversityDao();

    @Override
    public Program getUniversityDetails(Program program) throws SQLException {
        Program universityDetail = new Program();
        List<Program> universityDetails = searchUniversityDao.fetchAll();
        for(Program detail : universityDetails) {
            if (detail.getUniversityName().equals(program.getUniversityName())) {
                universityDetail.setUserId(detail.getUserId());
                universityDetail.setUniversityName(detail.getUniversityName());
                universityDetail.setUniversityDescription(detail.getUniversityDescription());
            } else {
                universityDetail.setUniversityName("");
            }
        }
        return universityDetail;
    }

    @Override
    public List<Program> getProgramDetails(int id) throws SQLException {
        return searchUniversityDao.fetchAllByParams(id);
    }
}

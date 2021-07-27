
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
        for (int i = 0; i < universityDetails.size(); i++){
            if(universityDetails.get(i).getUniversityName().equals(program.getUniversityName())) {
                universityDetail.setUserId(universityDetails.get(i).getUserId());
                universityDetail.setUniversityName(universityDetails.get(i).getUniversityName());
                universityDetail.setUniversityDescription(universityDetails.get(i).getUniversityDescription());
                break;
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

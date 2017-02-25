package service.impl;

import dao.GradeDao;
import model.Exam;
import model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.GradeService;

import java.util.List;

/**
 * Created by ss14 on 2016/12/31.
 */
@Component
public class GradeServiceImpl implements GradeService {

    @Autowired
    private  GradeDao gradeDao;

    public GradeServiceImpl(){

    }

    public List<Exam> getUnAttendedExams(int stdId) {
        return gradeDao.getUnAttendedExams(stdId);
    }

    public List<Grade> getAllGrades(int stdId)
    {
        return gradeDao.getAllGrades(stdId);
    }
}

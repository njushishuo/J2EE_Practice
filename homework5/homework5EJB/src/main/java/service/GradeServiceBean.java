package service;

import dao.GradeDao;
import factory.EJBFactory;
import model.Exam;
import model.Grade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ss14 on 2016/12/31.
 */
@Stateless
public class GradeServiceBean implements GradeService {

    @EJB
    GradeDao gradeDao;

    public List<Exam> getUnAttendedExamIds(int stdId) {
        return gradeDao.getUnAttendedExamIds(stdId);
    }

    public List<Grade> getAllGrades(int stdId)
    {
        return gradeDao.getAllGrades(stdId);
    }
}

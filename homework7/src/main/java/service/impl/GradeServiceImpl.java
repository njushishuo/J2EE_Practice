package service.impl;

import dao.GradeDao;
import factory.DaoFactory;
import model.Exam;
import model.Grade;
import service.GradeService;

import java.util.List;

/**
 * Created by ss14 on 2016/12/31.
 */
public class GradeServiceImpl implements GradeService {

    private static GradeService gradeService ;
    private static GradeDao gradeDao;

    private GradeServiceImpl(){
        gradeDao = DaoFactory.getGradeDao();
    }


    public static GradeService getGradeServiceImpl(){
        if(gradeService==null){
            gradeService = new GradeServiceImpl();
        }
        return gradeService;
    }

    public List<Exam> getUnAttendedExamIds(int stdId) {
        return gradeDao.getUnAttendedExamIds(stdId);
    }

    public List<Grade> getAllGrades(int stdId)
    {
        return gradeDao.getAllGrades(stdId);
    }
}

package test.java.Dao;

import dao.GradeDao;
import dao.impl.GradeDaoImpl;
import model.Exam;
import model.Grade;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * Created by ss14 on 2016/12/18.
 */
public class GradeDaoTest {

    GradeDao dao;

    @Before
    public void setUp() throws Exception {
        dao =  GradeDaoImpl.getGradeDaoImpl();
    }

    @Test
    public void getUnAttendedExamIds() throws Exception {

        int stdId = 1;
        List<Exam> unAttendedExams = dao.getUnAttendedExamIds(stdId);
        assert unAttendedExams!=null:"null?";
        assert unAttendedExams.size()==2 : "!=2?";
        for(Exam exam : unAttendedExams){
            System.out.println(exam);
        }
    }

    @Test
    public void getAllGrades() throws Exception {
        int stdId = 2;
        List<Grade> grades = dao.getAllGrades(stdId);
        assert grades!=null:"null?";
        assert grades.size()==4 : "!=4?";
        for(Grade grade : grades){
            System.out.println(grade);
        }
    }

}
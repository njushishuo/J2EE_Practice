package dao.impl;

import dao.GradeDao;
import model.Exam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by ss14 on 2017/2/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:/applicationContext.xml")
public class GradeDaoImplTest {

    @Autowired
    GradeDao dao;

    @Test
    public void getUnAttendedExams() throws Exception {
        List<Exam> result = dao.getUnAttendedExams(1);
        for(Exam exam : result){
            if(exam!=null){
                System.err.println(exam.getCourseName());
            }
        }

    }

    @Test
    public void getAllGrades() throws Exception {

    }

}
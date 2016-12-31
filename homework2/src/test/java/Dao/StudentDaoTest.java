package Dao;

import model.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2016/12/18.
 */
public class StudentDaoTest {

    StudentDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new StudentDao();
    }
    @Test

    public void exists() throws Exception {

        String username = "ss14";
        assert true==dao.exists(username):"exists error";
    }

    @Test
    public void getStudentByUsername() throws Exception {
        String username = "ss14";
        Student student  = dao.getStudentByUsername(username);
        assert student!=null : "getStudent error";
        System.out.println(student.getUsername()+"  "+student.getName());
    }

}
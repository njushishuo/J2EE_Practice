package service;



import dao.StudentDao;
import factory.EJBFactory;
import model.Student;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Created by ss14 on 2016/12/31.
 */
@Stateless
public class StudentServiceBean implements StudentService {

    @EJB
    StudentDao  studentDao;

    public boolean exists(String username) {
        return studentDao.exists(username);
    }

    public Student getStudentByUsername(String username) {
        return studentDao.getStudentByUsername(username);
    }
}

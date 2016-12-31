package service.impl;

import dao.StudentDao;
import factory.DaoFactory;
import model.Student;
import service.StudentService;

/**
 * Created by ss14 on 2016/12/31.
 */
public class StudentServiceImpl implements StudentService {

    private static StudentService studentService;
    private static StudentDao studentDao;

    private StudentServiceImpl(){
        studentDao = DaoFactory.getStudentDao();
    }

    public static StudentService getStudentServiceImpl(){
        if(studentService==null){
            studentService = new StudentServiceImpl();
        }
        return studentService;
    }


    public boolean exists(String username) {
        return studentDao.exists(username);
    }

    public Student getStudentByUsername(String username) {
        return studentDao.getStudentByUsername(username);
    }
}

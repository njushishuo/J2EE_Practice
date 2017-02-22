package service.impl;

import dao.StudentDao;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.StudentService;

/**
 * Created by ss14 on 2016/12/31.
 */
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private  StudentDao studentDao;

    public StudentServiceImpl(){

    }

    public boolean exists(String username) {
        return studentDao.exists(username);
    }

    public Student getStudentByUsername(String username) {
        return studentDao.getStudentByUsername(username);
    }
}

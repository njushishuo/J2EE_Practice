package service;

import model.Student;

/**
 * Created by ss14 on 2016/12/31.
 */
public interface StudentService {

    boolean exists(String username );

    Student getStudentByUsername(String username);
}

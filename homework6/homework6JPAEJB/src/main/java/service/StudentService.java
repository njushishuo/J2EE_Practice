package service;

import model.Student;

import javax.ejb.Remote;

/**
 * Created by ss14 on 2016/12/31.
 */
@Remote
public interface StudentService {

    boolean exists(String username);

    Student getStudentByUsername(String username);
}

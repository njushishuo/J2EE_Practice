package dao;

import model.Student;

import javax.ejb.Local;
import javax.ejb.Remote;

/**
 * Created by ss14 on 2016/12/31.
 */
@Remote
public interface StudentDao {


    boolean exists(String username);


    Student getStudentByUsername(String username);
}

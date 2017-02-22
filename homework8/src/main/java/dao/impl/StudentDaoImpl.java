package dao.impl;

import dao.StudentDao;
import model.Student;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ss14 on 2016/12/18.
 */

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    protected SessionFactory sessionFactory;


    private static String tableName = Student.class.getName();

    public StudentDaoImpl(){

    }

    public boolean exists(String username ){

        // 打开线程安全的Session对象
        Session session = sessionFactory.openSession();
        String hql = " from "+tableName;
        Query query = session.createQuery(hql);
        List resultList  =query.list();
        System.err.println("resultList:"+ resultList.size());
        for(int i=0;i<resultList.size();i++){
            Student student = (Student) resultList.get(i);
            System.err.println( student.getUsername());
        }
        session.clear();
        session.close();
        return  (resultList.size()==0)? false:true;

    }

    public Student getStudentByUsername(String username){

        // 打开线程安全的Session对象
        Session session = sessionFactory.openSession();
        String hql = " from model.Student as Student where Student.username = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,username);
        List resultList = query.list();

        session.clear();
        session.close();
        return (resultList.size()==0)?null: (Student) resultList.get(0);

    }


}

package dao.impl;

import dao.StudentDao;
import model.Student;
import org.hibernate.Session;
import org.hibernate.Query;
import tools.HibernateUtil;
import java.util.List;

/**
 * Created by ss14 on 2016/12/18.
 */
public class StudentDaoImpl implements StudentDao {

    private static StudentDaoImpl studentDaoImpl;

    private static String tableName = Student.class.getName();

    private StudentDaoImpl(){

    }

    public static StudentDaoImpl getStudentDaoImpl(){
        if(studentDaoImpl==null){
            studentDaoImpl = new StudentDaoImpl();
        }
        return studentDaoImpl;
    }

    public boolean exists(String username ){

        // 打开线程安全的Session对象
        Session session = HibernateUtil.currentSession();
        String hql = " from "+tableName;
        Query query = session.createQuery(hql);
        List resultList  =query.list();
        System.err.println("resultList:"+ resultList.size());
        for(int i=0;i<resultList.size();i++){
            Student student = (Student) resultList.get(i);
            System.err.println( student.getUsername());
        }

        return  (resultList.size()==0)? false:true;

    }

    public Student getStudentByUsername(String username){

        // 打开线程安全的Session对象
        Session session = HibernateUtil.currentSession();
        String hql = " from model.Student as Student where Student.username = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,username);
        List resultList = query.list();
        return (resultList.size()==0)?null: (Student) resultList.get(0);

    }


}

package dao;

import model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ss14 on 2016/12/18.
 */
@Stateless
public class StudentDaoBean implements StudentDao {


    @PersistenceContext
    private EntityManager em;

    public boolean exists(String username ){

        System.err.println(username+"--------------------");
        Query query  = em.createQuery("select s from Student s where s.username = ?1");
        query.setParameter(1,username);
        List student = query.getResultList();
        if(student==null){
            return false;
        }else if (student.size()<1){
            return false;
        }

        return true;
    }

    public Student getStudentByUsername(String username){

        Query query  = em.createQuery("select s from Student s where s.username = ?1");
        query.setParameter(1,username);
        List result = query.getResultList();
        if(result==null){
                return null;
                }else if(result.size()==0){
                return null;
                }else{
                return (Student)(result.get(0));
                }
                }


                }

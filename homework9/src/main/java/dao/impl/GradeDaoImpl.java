package dao.impl;

import dao.GradeDao;
import model.Exam;
import model.Grade;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ss14 on 2016/12/18.
 */
@Repository
public class GradeDaoImpl implements GradeDao {
    @Autowired
    protected SessionFactory sessionFactory;

    public GradeDaoImpl(){

    }

    /**
     * 返回未参加的测验
     * 如果参加过全部测验，返回的list.size==0
     * @param stdId
     * @return
     */
    public List<Exam> getUnAttendedExams(int stdId){

        // 打开线程安全的Session对象
        Session session = sessionFactory.openSession();
        String hql = "select Exam from model.Exam as Exam , model.Grade as Grade where  Grade .score is null and Exam.id = Grade.exam.id and Grade.studentId = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,stdId);
        List resultList = query.list();

        session.clear();
        session.close();
        return resultList;

    }

    public List<Grade> getAllGrades(int stdId){
        // 打开线程安全的Session对象
        Session session = sessionFactory.openSession();
        String hql = " from model.Grade as Grade where Grade.studentId =?";
        Query query = session.createQuery(hql);
        query.setParameter(0,stdId);
        List resultList = query.list();

        session.clear();
        session.close();
        return resultList;
    }
}

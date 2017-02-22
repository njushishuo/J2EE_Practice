package dao.impl;

import dao.GradeDao;
import model.Exam;
import model.Grade;
import org.hibernate.Session;
import tools.HibernateUtil;
import org.hibernate.Query;
import java.util.List;

/**
 * Created by ss14 on 2016/12/18.
 */
public class GradeDaoImpl implements GradeDao {


    private static GradeDaoImpl gradeDaoImpl;


    private GradeDaoImpl(){

    }

    public static GradeDaoImpl getGradeDaoImpl (){
        if(gradeDaoImpl==null){
            gradeDaoImpl = new GradeDaoImpl();
        }

        return gradeDaoImpl;
    }

    /**
     * 返回未参加的测验
     * 如果参加过全部测验，返回的list.size==0
     * @param stdId
     * @return
     */
    public List<Exam> getUnAttendedExamIds(int stdId){

        // 打开线程安全的Session对象
        Session session = HibernateUtil.currentSession();
        String hql = "select Exam from model.Exam as Exam , model.Grade as Grade where  Grade .score is null and Exam.id = Grade.exam.id and Grade.studentId = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,stdId);
        List resultList = query.list();
        return resultList;

    }



    public List<Grade> getAllGrades(int stdId){
        // 打开线程安全的Session对象
        Session session = HibernateUtil.currentSession();
        String hql = " from model.Grade as Grade where Grade.studentId =?";
        Query query = session.createQuery(hql);
        query.setParameter(0,stdId);
        List resultList = query.list();
        return resultList;
    }
}

package dao;

import model.Exam;
import model.Grade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ss14 on 2016/12/18.
 */
@Stateless
public class GradeDaoBean implements GradeDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * 返回未参加的测验
     * 如果参加过全部测验，返回的list.size==0
     * @param stdId
     * @return
     */
    public List<Exam> getUnAttendedExamIds(int stdId){

        Query query = em.createQuery
                ("select e from Grade g,Exam e where g.studentId=?1 and g.score is NULL and e.id = g.exam.id");
        query.setParameter(1,stdId);
        List examList = query.getResultList();
        return examList;

    }

    public List<Grade> getAllGrades(int stdId){

        Query query = em.createQuery("select g from  Grade g   where  g.studentId=?1");
        query.setParameter(1,stdId);
        List gradeList= query.getResultList();
        return gradeList;

    }
}

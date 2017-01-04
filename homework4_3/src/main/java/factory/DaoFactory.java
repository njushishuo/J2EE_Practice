package factory;

import dao.GradeDao;
import dao.StudentDao;
import dao.impl.GradeDaoImpl;
import dao.impl.StudentDaoImpl;

/**
 * Created by ss14 on 2016/12/31.
 */
public class DaoFactory {

    public static GradeDao getGradeDao(){
        return GradeDaoImpl.getGradeDaoImpl();
    }


    public static StudentDao getStudentDao(){
        return StudentDaoImpl.getStudentDaoImpl();
    }
}

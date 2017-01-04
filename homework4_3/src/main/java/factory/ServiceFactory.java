package factory;

import service.GradeService;
import service.StudentService;
import service.impl.GradeServiceImpl;
import service.impl.StudentServiceImpl;

/**
 * Created by ss14 on 2016/12/31.
 */
public class ServiceFactory {

    public static StudentService getStudentService(){
        return StudentServiceImpl.getStudentServiceImpl();
    }

    public static GradeService getGradeService(){
        return GradeServiceImpl.getGradeServiceImpl();
    }

}

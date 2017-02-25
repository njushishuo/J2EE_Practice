package action;

import bean.ExamListBean;
import bean.GradeListBean;
import model.Exam;
import model.Grade;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import service.GradeService;
import tools.AttrStrings;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ss14 on 2017/2/25.
 */

@Controller
public class GradeAction extends BaseAction{


    @Qualifier("gradeServiceImpl")
    @Autowired
    GradeService gradeService;
    public String execute() throws Exception {

        HttpSession session = request.getSession(false);
        //已经登陆了
        if (session != null && session.getAttribute(AttrStrings.isVisitorAttr) != null && session.
                getAttribute(AttrStrings.isVisitorAttr).equals("false")) {

            Student student = (Student) session.getAttribute(AttrStrings.student);
            ServletContext context = request.getServletContext();
            //未参加的课程
            List<Exam> unAttendedExams = gradeService.getUnAttendedExams(student.getId());

            if (unAttendedExams.size() != 0) {
                ExamListBean examListBean = new ExamListBean();
                examListBean.setExamList(unAttendedExams);
                session.setAttribute(AttrStrings.examList, examListBean);
                //context.getRequestDispatcher("/jsp/warning.jsp").forward(request, response);
                return "warning";
            } else {
                List<Grade> grades = gradeService.getAllGrades(student.getId());
                GradeListBean gradeListBean = new GradeListBean();
                gradeListBean.setGradeList(grades);
                session.setAttribute(AttrStrings.gradeList, gradeListBean);
                //context.getRequestDispatcher("/jsp/exams.jsp").forward(request, response);
                return "success";
            }
        } else {

            //response.sendRedirect("/Login");
            return "login";
        }
    }

}

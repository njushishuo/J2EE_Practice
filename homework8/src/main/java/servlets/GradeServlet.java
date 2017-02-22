package servlets;

/**
 * Created by ss14 on 2017/1/1.
 */

import action.business.ExamListBean;
import action.business.GradeListBean;

import model.Exam;
import model.Grade;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import service.GradeService;
import service.StudentService;
import tools.AttrStrings;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Grade")
public class GradeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static ApplicationContext appliationContext;
    private static GradeService gradeService;

    public GradeServlet() {

    }

    public void init() throws ServletException {
        super.init();
        appliationContext = new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml");
        gradeService = (GradeService) appliationContext.getBean("GradeService");
    }


    //用于返回成绩界面
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        //已经登陆了
        if(session!=null&&session.getAttribute(AttrStrings.isVisitorAttr)!=null&&session.
                getAttribute(AttrStrings.isVisitorAttr).equals("false")){

            Student student = (Student) session.getAttribute(AttrStrings.student);
            ServletContext context = request.getServletContext();
            //未参加的课程
            List<Exam> unAttendedExams = gradeService.getUnAttendedExams(student.getId());

            if (unAttendedExams.size() != 0) {
                ExamListBean examListBean = new ExamListBean();
                examListBean.setExamList(unAttendedExams);
                session.setAttribute(AttrStrings.examList, examListBean);
                context.getRequestDispatcher("/jsp/warning.jsp").forward(request, response);
            } else {
                List<Grade> grades = gradeService.getAllGrades(student.getId());
                GradeListBean gradeListBean = new GradeListBean();
                gradeListBean.setGradeList(grades);
                session.setAttribute(AttrStrings.gradeList, gradeListBean);
                context.getRequestDispatcher("/jsp/exams.jsp").forward(request, response);
            }
        }else{
            response.sendRedirect("/Login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}

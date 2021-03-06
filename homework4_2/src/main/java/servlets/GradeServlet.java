package servlets;

/**
 * Created by ss14 on 2017/1/1.
 */

import factory.ServiceFactory;
import model.Exam;
import model.Grade;
import model.Student;
import service.GradeService;
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

    private GradeService gradeService;

    public GradeServlet(){
        gradeService = ServiceFactory.getGradeService();
    }


    //用于返回成绩界面
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        //已经登陆了
        if(session!=null&&session.getAttribute(AttrStrings.isVisitorAttr).equals("false")){

            Student student = (Student) session.getAttribute(AttrStrings.student);
            ServletContext context = request.getServletContext();
            //未参加的课程
            List<Exam> unAttendedExams = gradeService.getUnAttendedExamIds(student.getId());

            if (unAttendedExams.size() != 0) {

                request.setAttribute("unAttendedExams", unAttendedExams);
                context.getRequestDispatcher("/jsp/warning.jsp").forward(request, response);

            } else {

                List<Grade> grades = gradeService.getAllGrades(student.getId());
                request.setAttribute("grades", grades);
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

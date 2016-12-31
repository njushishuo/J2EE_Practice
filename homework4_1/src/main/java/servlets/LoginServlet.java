package servlets;

import Dao.GradeDao;
import Dao.StudentDao;
import model.Exam;
import model.Grade;
import model.Student;
import tools.AttrStrings;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private StudentDao studentDao;
    private GradeDao gradeDao;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
        studentDao = new StudentDao();
        gradeDao = new GradeDao();
    }


    //用于返回登陆界面
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		// TODO Auto-generated method stub

        HttpSession session = request.getSession(false);
        if(session!=null&&session.getAttribute(AttrStrings.isVisitorAttr)!=null){


            ServletContext context=request.getServletContext();

            if(session.getAttribute(AttrStrings.isVisitorAttr).equals("true")){

                //游客计数器减一
                session.removeAttribute(AttrStrings.isVisitorAttr);
                //总人数计数器减一
                session.invalidate();
                session=null;

            }else{
                //用户计数器减一
                session.removeAttribute(AttrStrings.isVisitorAttr);
                //总人数计数器减一
                session.invalidate();
                session=null;
            }


        }

        ServletContext context=request.getServletContext();
        Integer visitorCount= (Integer) context.getAttribute(AttrStrings.visitorCountAttr);
        Integer userCount= (Integer) context.getAttribute(AttrStrings.userCountAttr);
        Integer sumCount= (Integer) context.getAttribute(AttrStrings.sumCountAttr);

        response.setContentType("text/html");
        //response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <!-- 新 Bootstrap 核心 CSS 文件 -->\n" +
                "    <link rel=\"stylesheet\" href=\"http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css\">\n" +
                "    <!-- 可选的Bootstrap主题文件（一般不用引入） -->\n" +
                "    <link rel=\"stylesheet\" href=\"http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css\">\n" +
                "    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->\n" +
                "    <script src=\"http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js\"></script>\n" +
                "    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->\n" +
                "    <script src=\"http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n" +
                "\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>标准</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"row\">\n" +
                "    <div class=\"col-md-4 col-md-offset-4\">\n" +
                "        <h1>欢迎</h1>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"row\">\n" +
                "    <div class=\"col-md-4 col-md-offset-4\">\n" +
                "        <form method=\"post\" role=\"form\" action=\"/Login\">\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"username\">用户名</label>\n" +
                "                <input type=\"text\" class=\"form-control\" name=\"username\" id=\"username\" >\n" +
                "            </div>\n" +
                "            <div class=\"form-group\">\n" +
                "                <label for=\"password\">密码</label>\n" +
                "                <input type=\"password\" class=\"form-control\" name=\"password\" id=\"password\">\n" +
                "            </div>\n" +
                "            <button type=\"submit\" class=\" btn btn-default\">用户登陆</button>\n" +
                "        </form>\n" +
                "\n" +
                "        <span >没有账号？</span>\n" +
                "        <a href=\"/visitor\">游客登陆</a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "<br>\n" +
                "<p>总人数: "+sumCount+"</p>\n" +
                "<p>已登陆人数: "+userCount+"</p>\n" +
                "<p>游客人数: "+visitorCount+"</p>"+
                "</body>\n" +
                "</html>"
        );


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		// TODO Auto-generated method stub


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(!studentDao.exists(username)){

            RequestDispatcher dispatcher
                    =request.getRequestDispatcher("/html/error.html");

            if (dispatcher!= null){
                dispatcher.include(request,response);
            }

        }else{

            Student student = studentDao.getStudentByUsername(username);
            //密码正确
            if(student.getPassword().equals(password)){

                //总人数计数器加一
                HttpSession session = request.getSession(true);
                //用户计数器加一
                session.setAttribute(AttrStrings.isVisitorAttr , "false");


                ServletContext context=request.getServletContext();
                //有未参加的课程
                List<Exam> unAttendedExams = gradeDao.getUnAttendedExamIds(student.getId());

                response.setContentType("text/html");
                //response.setCharacterEncoding("utf-8");
                PrintWriter out = response.getWriter();

                if(unAttendedExams.size()!=0){

		            out.println(
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <!-- 新 Bootstrap 核心 CSS 文件 -->\n" +
                            "    <link rel=\"stylesheet\" href=\"http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css\">\n" +
                            "    <!-- 可选的Bootstrap主题文件（一般不用引入） -->\n" +
                            "    <link rel=\"stylesheet\" href=\"http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css\">\n" +
                            "    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->\n" +
                            "    <script src=\"http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js\"></script>\n" +
                            "    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->\n" +
                            "    <script src=\"http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n" +
                            "\n" +
                            "    <title>标准</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <div class=\"row\">\n" +
                            "    <div class=\"col-md-12\">\n" +
                            "        <div class=\"panel panel-danger\">\n" +
                            "            <!-- Default panel contents -->\n" +
                            "            <div class=\"panel-heading\"><span style=\"font-size: 20px; \">未参与的测验</span></div>\n" +
                            "            <div class=\"panel-body\">\n" +
                            "                <!-- Table -->\n" +
                            "                <table class=\"table\">\n" +
                            "                    <thead>\n" +
                            "                    <tr>\n" +
                            "                        <th>测验Id</th>\n" +
                            "                        <th>科目</th>\n" +
                            "                        <th>开始时间</th>\n" +
                            "                        <th>结束时间</th>\n" +
                            "                    </tr>\n" +
                            "                    </thead>\n" +
                            "                    <tbody>");

                    for(Exam exam : unAttendedExams){
                        out.print("<tr>");
                        out.print("<td>"+exam.getId()+"</td>");
                        out.print("<td>"+exam.getCourseName()+"</td>");
                        out.print("<td>"+exam.getStart_at()+"</td>");
                        out.print("<td>"+exam.getEnd_at()+"</td>");
                        out.println("</tr>");
                    }

                    out.println("  </tbody>\n" +
                            "                </table>\n" +
                            "            </div>\n" +
                            "        </div>\n" +
                            "<a  href=\"/Login\" style=\"font-size: 40px\">注销</a>"+
                            "    </div>\n" +
                            "</div>\n" +
                            "</body>\n" +
                            "</html>");

                }else{

                    List<Grade> grades = gradeDao.getAllGrades(student.getId());
                    out.println(
                            "<html lang=\"en\">\n" +
                                "<head>\n" +
                                "    <!-- 新 Bootstrap 核心 CSS 文件 -->\n" +
                                "    <link rel=\"stylesheet\" href=\"http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css\">\n" +
                                "    <!-- 可选的Bootstrap主题文件（一般不用引入） -->\n" +
                                "    <link rel=\"stylesheet\" href=\"http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css\">\n" +
                                "    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->\n" +
                                "    <script src=\"http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js\"></script>\n" +
                                "    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->\n" +
                                "    <script src=\"http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\n" +
                                "\n" +
                                "    <title>标准</title>\n" +
                                "</head>\n" +
                                "<body>\n" +
                                "    <div class=\"row\">\n" +
                                "        <div class=\"col-md-12\">\n" +
                                "                <div class=\"panel panel-success\">\n" +
                                "                    <!-- Default panel contents -->\n" +
                                "                    <div class=\"panel-heading\"><span style=\"font-size: 20px; \">测验成绩</span></div>\n" +
                                "                    <div class=\"panel-body\">\n" +
                                "                        <!-- Table -->\n" +
                                "                        <table class=\"table\">\n" +
                                "                            <thead>\n" +
                                "                                <tr>\n" +
                                "                                    <th>课程名</th>\n" +
                                "                                    <th>任课老师</th>\n" +
                                "                                    <th>成绩</th>\n" +
                                "                                </tr>\n" +
                                "                            </thead>\n" +
                                "                            <tbody>");

                            for(Grade grade : grades){
                                Exam exam = grade.getExam();
                                out.print("<tr>");
                                out.print("<td>"+exam.getId()+"</td>");
                                out.print("<td>"+exam.getCourseName()+"</td>");
                                out.print("<td>"+exam.getStart_at()+"</td>");
                                out.print("<td>"+exam.getEnd_at()+"</td>");
                                out.print("<td>"+grade.getScore()+"</td>");
                                out.println("</tr>");
                            }

                    out.print("  </tbody>\n" +
                            "                </table>\n" +
                            "            </div>\n" +
                            "<a  href=\"/Login\" style=\"font-size: 40px\">注销</a>"+
                            "        </div>\n" +
                            "    </div>\n" +
                            "</div>\n" +
                            "</body>\n" +
                            "</html>");
                }



                Integer visitorCnt= (Integer) context.getAttribute(AttrStrings.visitorCountAttr);
                Integer userCnt= (Integer) context.getAttribute(AttrStrings.userCountAttr);
                Integer sumCnt= (Integer) context.getAttribute(AttrStrings.sumCountAttr);
                out.println(
                        "    <br>\n" +
                                "    <p>总人数: "+sumCnt+"</p>\n" +
                                "    <p>已登陆人数: "+userCnt+"</p>\n" +
                                "    <p>游客人数: "+visitorCnt+"</p>");

            }else{

                //TODO 密码错误提示



            }
        }

	}



}

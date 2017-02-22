package servlets;


import model.Student;
import service.StudentService;
import tools.AttrStrings;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @EJB
    StudentService studentService;

    public LoginServlet() {
        super();
    }


    //用于返回登陆界面
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


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

        ServletContext context = request.getServletContext();
        context.getRequestDispatcher("/jsp/login.jsp").forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(!studentService.exists(username)){

            RequestDispatcher dispatcher
                    =request.getRequestDispatcher("/html/error.html");

            if (dispatcher!= null){
                dispatcher.include(request,response);
            }

        }else{

            Student student = studentService.getStudentByUsername(username);
            //密码正确
            if(student.getPassword().equals(password)){

                //总人数计数器加一
                HttpSession session = request.getSession(true);
                //用户计数器加一
                session.setAttribute(AttrStrings.isVisitorAttr ,"false");
                session.setAttribute(AttrStrings.student ,student);

                response.sendRedirect(AttrStrings.contextRoot+"/Grade");

            }else{

                //TODO 密码错误提示



            }
        }

	}



}

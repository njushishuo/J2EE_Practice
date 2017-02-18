package servlets;


import tools.AttrStrings;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ss14 on 2016/12/19.
 */
@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public VisitorServlet() {
        super();
    }


    /**
     * 响应点击游客登陆按钮,返回游客浏览的界面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        //总人数计数器加一
        HttpSession session = request.getSession(true);
        //游客计数器加一
        session.setAttribute(AttrStrings.isVisitorAttr ,"true");


        ServletContext context=request.getServletContext();

        context.getRequestDispatcher("/jsp/visitor.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse respone)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

    }
}

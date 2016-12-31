package servlets;


import tools.AttrStrings;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

        Integer visitorCnt= (Integer) context.getAttribute(AttrStrings.visitorCountAttr);
        Integer userCnt= (Integer) context.getAttribute(AttrStrings.userCountAttr);
        Integer sumCnt= (Integer) context.getAttribute(AttrStrings.sumCountAttr);

        response.setContentType("text/html");
        //response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println(

                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>欢迎</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <p>\n" +
                "        欢迎，这里是游客界面\n" +
                "    </p>\n" +
                "    <a href=\"/Login\">我要登陆</a>\n" +
                "\n" +
                "    <br>\n" +
                "    <p>总人数: "+sumCnt+"</p>\n" +
                "    <p>已登陆人数: "+userCnt+"</p>\n" +
                "    <p>游客人数: "+visitorCnt+"</p>"+
                "</body>\n" +
                "</html>"
                );



    }


    protected void doPost(HttpServletRequest request, HttpServletResponse respone)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

    }
}

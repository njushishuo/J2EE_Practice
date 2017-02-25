package tag;

import tools.AttrStrings;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by ss14 on 2017/1/4.
 */
public class CheckLoginHandler extends BodyTagSupport {
    @Override
    public int doEndTag() throws JspException
    {
            HttpSession session = pageContext.getSession();
            HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();

            if(session!=null) {
                System.out.println("attr: " + session.getAttribute(AttrStrings.isVisitorAttr));
            }
            //未登陆
            if(!( session!=null&&session.getAttribute(AttrStrings.isVisitorAttr)!=null&&
                    session.getAttribute(AttrStrings.isVisitorAttr).equals("false") )) {
                System.out.println("redirect!!!");
                try {
                    response.sendRedirect("/Login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return SKIP_PAGE;

            }else{
                return EVAL_PAGE;
            }
    }
}

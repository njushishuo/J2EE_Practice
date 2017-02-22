package tag;

import action.business.ExamListBean;
import model.Exam;
import tools.AttrStrings;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by ss14 on 2017/1/4.
 */
public class ExamListHandler extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {

        try {

            HttpSession session = ((PageContext)this.getJspContext()).getSession();
            ExamListBean listBean =  (ExamListBean) session.getAttribute(AttrStrings.examList);
            List<Exam> examList = listBean.getExamList();
            JspWriter out = getJspContext().getOut();
            for (int i = 0; i < examList.size(); i++) {
                Exam exam = examList.get(i);
                out.println("<tr><TD >"+ exam.getId()+"</TD>");
                out.println("<TD >"+ exam.getCourseName()+"</TD>");
                out.println("<TD >"+ exam.getStartAt()+"</TD>");
                out.println("<TD >"+ exam.getEndAt()+"</TD>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new JspException(e.getMessage());
        }
    }


}
package tag;


import action.business.GradeListBean;
import model.Exam;
import model.Grade;
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
public class GradeListHandler extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {

        try {

            HttpSession session = ((PageContext)this.getJspContext()).getSession();
            GradeListBean listBean =  (GradeListBean) session.getAttribute(AttrStrings.gradeList);
            List<Grade> gradeList = listBean.getGradeList();
            JspWriter out = getJspContext().getOut();
            for (int i = 0; i < gradeList.size(); i++) {
                Exam exam = gradeList.get(i).getExam();
                out.println("<tr><TD >"+ exam.getId()+"</TD>");
                out.println("<TD >"+ exam.getCourseName()+"</TD>");
                out.println("<TD >"+ exam.getStart_at()+"</TD>");
                out.println("<TD >"+ exam.getEnd_at()+"</TD>");
                out.println("<TD >"+ gradeList.get(i).getScore()+"</TD></tr>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new JspException(e.getMessage());
        }
    }


}
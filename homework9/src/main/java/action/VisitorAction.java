package action;

import org.springframework.stereotype.Controller;
import tools.AttrStrings;
import javax.servlet.http.HttpSession;

/**
 * Created by ss14 on 2017/2/25.
 */

@Controller
public class VisitorAction extends BaseAction{

    public String execute() throws Exception {

        //总人数计数器加一
        HttpSession session = request.getSession(true);
        //游客计数器加一
        session.setAttribute(AttrStrings.isVisitorAttr ,"true");

        return "success";

    }
}

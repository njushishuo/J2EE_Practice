package action;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import service.StudentService;
import tools.AttrStrings;

import javax.servlet.http.HttpSession;

/**
 * Created by ss14 on 2017/2/25.
 */
@Controller
public class LoginPostAction extends BaseAction {

    @Qualifier("studentServiceImpl")
    @Autowired
    StudentService studentService;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String execute() throws Exception {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(!studentService.exists(username)){

            return "error";

        }else{

            Student student = studentService.getStudentByUsername(username);
            //密码正确
            if(student.getPassword().equals(password)){

                //总人数计数器加一
                HttpSession session = request.getSession(true);
                //用户计数器加一
                session.setAttribute(AttrStrings.isVisitorAttr ,"false");
                session.setAttribute(AttrStrings.student ,student);

                return "success";

            }else{
                //TODO 密码错误提示
            }
        }

        return "";
    }
}

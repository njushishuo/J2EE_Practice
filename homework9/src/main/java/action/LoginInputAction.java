package action;


import org.springframework.stereotype.Controller;
import tools.AttrStrings;

/**
 * Created by ss14 on 2017/2/23.
 */

@Controller
public class LoginInputAction extends BaseAction {

    //get
    public String execute() throws Exception {

        if(session!=null&&session.get(AttrStrings.isVisitorAttr)!=null){

            if(session.get(AttrStrings.isVisitorAttr).equals("true")){

                //游客计数器减一
                session.remove(AttrStrings.isVisitorAttr);
                //总人数计数器减一
                session.invalidate();
                session=null;

            }else{
                //用户计数器减一
                session.remove(AttrStrings.isVisitorAttr);
                //总人数计数器减一
                session.invalidate();
                session=null;
            }
        }
        return "success";
    }


}

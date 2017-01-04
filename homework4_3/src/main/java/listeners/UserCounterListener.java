package listeners;


import tools.AttrStrings;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;


/**
 * Application Lifecycle Listener implementation class UserCounterListener
 *
 */
@WebListener
public class UserCounterListener implements HttpSessionListener,HttpSessionAttributeListener{


    /**
     * 每当有新用户登陆成功时，会创建新的session，总人数计数器加一
     * @param se
     */
    public void sessionCreated(HttpSessionEvent se) {
//        //总人数计数器加一
//        ServletContext context=se.getSession().getServletContext();
//        Integer sumCount=(Integer)context.getAttribute(AttrStrings.sumCountAttr);
//        sumCount++;
//        context.setAttribute(AttrStrings.sumCountAttr, sumCount);
//        System.err.println("sum++");
    }


    /**
     * 每当有已经登陆的用户退出时，会销毁session,总人数计数器减一
     * @param se
     */
    public void sessionDestroyed(HttpSessionEvent se) {
//        //总人数计数器减一
//        ServletContext context=se.getSession().getServletContext();
//        Integer sumCount=(Integer)context.getAttribute(AttrStrings.sumCountAttr);
//        sumCount--;
//        context.setAttribute(AttrStrings.sumCountAttr, sumCount);
    }



    public void attributeAdded(HttpSessionBindingEvent se) {

        ServletContext context=se.getSession().getServletContext();
        String name = se.getName();
        String value  = (String) se.getValue();

        if(name!=null&&value!=null){

            if(name.equals(AttrStrings.isVisitorAttr)){
                if(value.equals("true")){
                    //游客计数器加一
                    Integer visitorCount=(Integer)context.getAttribute(AttrStrings.visitorCountAttr);
                    visitorCount++;
                    context.setAttribute(AttrStrings.visitorCountAttr, visitorCount);
                    System.err.println("one visitor joined!");
                }else if(value.equals("false")){
                    //用户计数器加一
                    Integer userCount=(Integer)context.getAttribute(AttrStrings.userCountAttr);
                    userCount++;
                    context.setAttribute(AttrStrings.userCountAttr, userCount);
                    System.err.println("one user joined!");
                }

                //总人数计数器加一
                Integer sumCount=(Integer)context.getAttribute(AttrStrings.sumCountAttr);
                sumCount++;
                context.setAttribute(AttrStrings.sumCountAttr, sumCount);
                System.err.println("sum++");

            }


        }
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {
        ServletContext context=se.getSession().getServletContext();
        String name = se.getName();
        String value  = (String) se.getValue();
        if(name!=null&&value!=null){

            if(name.equals(AttrStrings.isVisitorAttr)){
                if(value.equals("true")){
                    //游客计数器减一
                    Integer visitorCount=(Integer)context.getAttribute(AttrStrings.visitorCountAttr);
                    visitorCount--;
                    context.setAttribute(AttrStrings.visitorCountAttr, visitorCount);
                    System.err.println("one visitor leaved!");
                }else if(value.equals("false")){
                    //用户计数器减一
                    Integer userCount=(Integer)context.getAttribute(AttrStrings.userCountAttr);
                    userCount--;
                    context.setAttribute(AttrStrings.userCountAttr, userCount);
                    System.err.println("one user leaved!");
                }

                //总人数计数器减一
                Integer sumCount=(Integer)context.getAttribute(AttrStrings.sumCountAttr);
                sumCount--;
                context.setAttribute(AttrStrings.sumCountAttr, sumCount);
                System.err.println("sum--");

            }

        }
    }

}

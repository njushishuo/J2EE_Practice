package listeners;

import tools.AttrStrings;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class CounterListener
 *
 */
@WebListener
public class CounterListener implements ServletContextListener, ServletContextAttributeListener {


    /**
     * Default constructor. 
     */
    public CounterListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent cse) {

    	ServletContext servletContext= cse.getServletContext();
    	servletContext.setAttribute(AttrStrings.sumCountAttr, new Integer(0));
    	servletContext.setAttribute(AttrStrings.visitorCountAttr, new Integer(0));
    	servletContext.setAttribute(AttrStrings.userCountAttr, new Integer(0));


        Integer visitorCount= (Integer) servletContext.getAttribute(AttrStrings.visitorCountAttr);
        Integer userCount= (Integer) servletContext.getAttribute(AttrStrings.userCountAttr);
        Integer sumCount= (Integer) servletContext.getAttribute(AttrStrings.sumCountAttr);

        System.err.println(sumCount);
        System.err.println(userCount);
        System.err.println(visitorCount);

    	System.out.println("Application initialized");
    }


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	System.out.println("Application shut down");
    }
	

}

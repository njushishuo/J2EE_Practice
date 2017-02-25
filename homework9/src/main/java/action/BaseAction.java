package action;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by ss14 on 2017/2/23.
 */
public class BaseAction implements SessionAware, ServletRequestAware
        , ServletResponseAware,ServletContextAware {

    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected SessionMap session;


    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;

    }

    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    public void setSession(Map<String, Object> map) {
        this.session = (SessionMap) map;
    }

    public void setServletContext(ServletContext servletContext) {
        this.context =servletContext;
    }
}

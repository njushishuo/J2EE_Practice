package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ss14 on 2016/12/19.
 */

@WebFilter(
        urlPatterns="/Login",
        filterName="CharSetFilter",
        initParams={
                @WebInitParam(name ="CharacterEncoding" ,value="utf-8"),
        }
)
public class CharSetFilter  implements Filter {

    private String CharacterEncoding;

    /**
     * Default constructor.
     */
    public CharSetFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            HttpServletRequest httpReq = (HttpServletRequest)request;
            HttpServletResponse httpRes = (HttpServletResponse)response;
            httpReq.setCharacterEncoding(this.CharacterEncoding);
            httpRes.setCharacterEncoding(this.CharacterEncoding);
        }//在servlet处理请求之前截获
        chain.doFilter(request, response);
        //	return;
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
        this.CharacterEncoding = fConfig.getInitParameter("CharacterEncoding");
    }

}
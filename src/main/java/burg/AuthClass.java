package burg;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;

public class AuthClass implements Filter {
    private FilterConfig config = null; 
    private boolean active = false; 

    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig; 
        String act = config.getInitParameter("active"); 
        if (act != null) active = (act.toUpperCase().equals("TRUE")); 
    }

    public void destroy(){
        config = null;
    }
//        ((HttpServletResponse)response).addDateHeader("Last-Modified", System.currentTimeMillis());
//        ((HttpServletResponse)response).setHeader("Cache-Control", "no-cache, no-store, private, max-age=0, s-maxage=0, must-revalidate, proxy-revalidate");
//        ((HttpServletResponse)response).setHeader("Pragma", "no-cache");
//        ((HttpServletResponse)response).setHeader("Expires", "0");

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException{
        chain.doFilter(request, response);
    }
}

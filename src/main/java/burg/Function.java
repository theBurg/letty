package burg;

import java.io.IOException;
import java.io.PrintWriter;

import java.lang.reflect.Method;

import javax.servlet.*;
import javax.servlet.http.*;

public class Function extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException,
                                                            IOException 
    {
        try
        {
            Class o = Class.forName("com.gm.pages."+"");
            Object p = o.newInstance();
            Method method = o.getMethod("method", new Class[]{HttpServletRequest.class, HttpServletResponse.class});
            Object[] input = {request, response};
            method.invoke(p, input);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException,
                                                            IOException 
    {
        try
        {
            Class o = Class.forName("com.gm.pages."+"");
            Object p = o.newInstance();
            Method method = o.getMethod("method", new Class[]{HttpServletRequest.class, HttpServletResponse.class});
            Object[] input = {request, response};
            method.invoke(p, input);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
























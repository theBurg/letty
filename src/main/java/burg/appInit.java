package burg;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import tbd.models.Typeobj;
//import factorys.hibernate;

//@WebListener
public class appInit implements ServletContextListener{
	
	static{
		
	}
	///////////////////////////////////////////////////////////////////////////
    public void contextInitialized(ServletContextEvent arg0)   { 
    	try{
    		System.out.println(arg0.getServletContext().getContextPath()+"appInit: typeobj deleted/");
    	}catch(Throwable ex){
    		ex.printStackTrace();
    		//LoggerPrinter.error(logger, LoggerMessages.ErrorGlobalDispatcherInitialized, ex, "");
    	}
    }
	///////////////////////////////////////////////////////////////////////////
    public void contextDestroyed(ServletContextEvent arg0)  {
    	
    }
}
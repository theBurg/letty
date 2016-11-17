package tbd;

import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
//import org.hibernate.event.LoadEventListener;
//import org.hibernate.event.def.DefaultLoadEventListener;


import tbd.dao.*;

public class hibernate {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            //return new Configuration().configure().buildSessionFactory();
        	Configuration ac = new Configuration();
                    ac.addAnnotatedClass(chat.class)
                    .addAnnotatedClass(users.class)
                    .addAnnotatedClass(msg.class);
        	//LoadEventListener[] loadEventListener = { new MyLoadListener(), new DefaultLoadEventListener() };
        	//ac.getEventListeners().setLoadEventListeners(loadEventListener);
		ac.configure("/src"); //configure("/mypath/hibernate.cfg.xml")
        	return ac.buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory(){
    	return sessionFactory;
    }

//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//    
//    public static void shutdown() {
//    	// Close caches and connection pools
//    	getSessionFactory().close();
//    }

}

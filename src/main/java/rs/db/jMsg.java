package rs.db;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

//import factorys.AbstractNetFactory;
import javax.ws.rs.client.Client;
//import org.apache.catalina.WebResource;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tbd.dao.msg;
import org.apache.derby.jdbc.EmbeddedDriver;
//import javax.annotation.PostConstruct;
import javax.ws.rs.core.Context;

//http://localhost:8080/JGHS/rest/go/download2
//@Stateless
@Path("msg")
public class jMsg {
    //@Context
    //HttpServletRequest request;
 
    @GET
    @Produces(MediaType.APPLICATION_JSON /*+ ";charset=utf-8"*/)
    public List<msg> all(){
        Map m = new HashMap<Integer, msg>();
        SessionFactory sf = tbd.hibernate.getSessionFactory();
        Session s = sf.openSession();
        List<msg> list = s.createCriteria(msg.class).list();
        s.close();
        return list; 
    }
    
    @GET
    @Path("{i}")
    @Produces(MediaType.APPLICATION_JSON /*+ ";charset=utf-8"*/)
    public Map<Integer, msg> getById(@PathParam("i") int i){
        Map map = new HashMap<Integer, msg>();
        SessionFactory sf = tbd.hibernate.getSessionFactory();
        Session s = sf.openSession();
        msg m = (msg)s.get(msg.class,new Integer(i));
        s.close();
        if(m!=null){
            System.out.println(m.getId());
            map.put(m.getId(), m);
            
        }
        //return "go1"; 
        return map; 
    }
    //http://localhost:8088/letty/rest/chat/s/[{"id":1,"name":"X"},{"id":2,"name":"Y"},{"id":3,"name":"Z"},{"id":4,"name":"РЇ"},{"id":5,"name":"РўС‹"},{"id":6,"name":"РћРЅ"},{"id":7,"name":"РћРЅР°"}]
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON /*+ ";charset=utf-8"*/)
    public msg setById(msg m){
        Session s = null;
        try{
            SessionFactory sf = tbd.hibernate.getSessionFactory();
            s = sf.openSession();
            s.beginTransaction();
                s.saveOrUpdate(m);
            s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
            //throw e;
        }finally{
            s.close();
        }
        return m; 
    }
}
package rs.db;
//https://habrahabr.ru/post/132385/

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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import tbd.dao.chat;
import org.apache.derby.jdbc.EmbeddedDriver;
//import javax.annotation.PostConstruct;
import javax.ws.rs.core.Context;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


//http://localhost:8080/JGHS/rest/go/download2
//@Stateless
@Path("chat")
public class jChat {
    //@Context
    //HttpServletRequest request;
 
    @GET
    @Produces(MediaType.APPLICATION_JSON /*+ ";charset=utf-8"*/)
    public List<chat> all(){
        Map m = new HashMap<Integer, chat>();
        SessionFactory sf = tbd.hibernate.getSessionFactory();
        Session s = sf.openSession();
        List<chat> list = s.createCriteria(chat.class).list();
        s.close();
        return list; 
    }
    //Чат по номеру
    @GET
    @Path("{i}")
    @Produces(MediaType.APPLICATION_JSON /*+ ";charset=utf-8"*/)
    public Map<Integer, chat> getById(@PathParam("i") int i){
        Map m = new HashMap<Integer, chat>();
        SessionFactory sf = tbd.hibernate.getSessionFactory();
        Session s = sf.openSession();
        chat c = (chat)s.get(chat.class,new Integer(i));
        s.close();
        if(c!=null){
            System.out.println(c.getName());
            m.put(c.getId(), c);
            
        }
        //return "go1"; 
        return m; 
    }
    //Чаты по пользователю
    @GET
    @Path("/user/{i}")
    @Produces(MediaType.APPLICATION_JSON /*+ ";charset=utf-8"*/)
    public List<chat> getByUserId(@PathParam("i") int i){
        //Map m = new HashMap<Integer, chat>();
        SessionFactory sf = tbd.hibernate.getSessionFactory();
        Session s = sf.openSession();
        List<chat> c=(List<chat>)s.createCriteria(chat.class).createAlias("users", "u").add(Restrictions.eq("u.id", i))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)//ToDo: баг ли это HB, или я накосячил с описанием ???
                .list();
        //chat c = (chat)s.get(chat.class,new Integer(i));
        s.close();
        return c;
    }
    //http://localhost:8088/letty/rest/chat/s/[{"id":1,"name":"X"},{"id":2,"name":"Y"},{"id":3,"name":"Z"},{"id":4,"name":"РЇ"},{"id":5,"name":"РўС‹"},{"id":6,"name":"РћРЅ"},{"id":7,"name":"РћРЅР°"}]
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON /*+ ";charset=utf-8"*/)
    public chat setById(chat c){
        Session s = null;
        try{
            SessionFactory sf = tbd.hibernate.getSessionFactory();
            s = sf.openSession();
            s.beginTransaction();
                s.saveOrUpdate(c);
            s.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
            //throw e;
        }finally{
            s.close();
        }
        return c; 
    }
    @GET
    @Path("/form")
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON /*+ ";charset=utf-8"*/)
    public void getForm(@Context HttpServletRequest request, 
                        @Context HttpServletResponse response) throws ServletException, IOException{
        //return new Viewable("/jsps/someJsp.jsp", null);
        request.getRequestDispatcher("/form.jsp").forward(request, response); ///WEB-INF/pages/blog/home.jsp
        request.equals(this);
    }
}
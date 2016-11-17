package burg.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Servlet implementation class go
 */
@Path("/hello")
public class go {
	
	@GET
	//@Path("/images/{image}")
	//@Produces("image/*")
	public Response getImage(@PathParam("image") String image) {
	  //File f = new File(image);
	 
	  //if (!f.exists()) {
	  //  throw new WebApplicationException(404);
	  //}
	 
	  //String mt = new MimetypesFileTypeMap().getContentType(f);
	  //return Response.ok(f, mt).build();
	  return Response.ok("OK").build();
	}

}

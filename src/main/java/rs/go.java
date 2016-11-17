package rs;


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


//http://localhost:8080/JGHS/rest/go/download2
@Path("go")
public class go {

	@GET
	public String go(){
		return "go1";
	}
	
	@GET
	@Path("{i}")
	//@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String goOneG_(@PathParam("i") int i, @QueryParam("j") String j, @QueryParam("crop[width]") String crop_width){
		return "get/one i="+i+" j="+j+" "+crop_width;
	}

	@GET
	@Path("/one/{i}")
	//@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String goOneG(@PathParam("i") int i, @QueryParam("j") String j, @QueryParam("crop[width]") String crop_width){
		return "get/one i="+i+" j="+j+" "+crop_width;
	}
	
	@POST
	@Path("/one/{i}")
	//http://localhost:8080/JGHS/rest/go/one/15
	//@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String goOneP(@FormParam("i") int i, @FormParam("j") String j, @FormParam("crop[width]") String crop_width){
		return "get/one i="+i+" j="+j+" "+crop_width;
	}
	
	@GET
	@Path("/goG/{i}")
	public Response get(@PathParam("i") int i, @QueryParam("j") int j){
		
		return Response.status(200)
				.entity("i="+i+"; j="+j)
				.build();
	}
	
	////////////////////////////////////////////////////////////////////////
	String urn = "upload";
	String uri = "http://localhost:8080/restfullwebservice/resources/generic";
	String jpgPath = "c:/Users/mir/Desktop/1.jpg";
    //final URI Uri = UriBuilder.fromUri(uri).build("");
	////////////////////////////////////////////////////////////////////////
	//POST FILE
	@GET
	@Path("/download")
	public Response sendFile() throws Exception{
		return Response.ok(new File(jpgPath), "application/jpg")
				.header("Content-Disposition", "attachment; filename=\"11.jpg\"")
				.build();
	}

	///////////////////////////////////////////////////////////////////////////
//	@POST
//	@Path("/upload")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	public Response uploadFile(
//		@FormDataParam("file") InputStream uploadedInputStream,
//		@FormDataParam("file") FormDataContentDisposition fileDetail) {
//		String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();
//		// save it
//		writeToFile(uploadedInputStream, uploadedFileLocation);
//		String output = "File uploaded to : " + uploadedFileLocation;
//		return Response.status(200).entity(output).build();
//	}
//
//	
//	
//	// save uploaded file to new location
//	private void writeToFile(InputStream uploadedInputStream,
//		String uploadedFileLocation) {
//		try {
//			OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
//			int read = 0;
//			byte[] bytes = new byte[1024];
//			out = new FileOutputStream(new File(uploadedFileLocation));
//			while ((read = uploadedInputStream.read(bytes)) != -1) {
//				out.write(bytes, 0, read);
//			}
//			out.flush();
//			out.close();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//	}

	
	//QR_CODE
	//http://stackoverflow.com/questions/3496209/input-and-output-binary-streams-using-jersey
}
//http://localhost:8080/JGHS/rest/go/one/77?j=88&crop[width]=[1,2,3]

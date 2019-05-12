package fr.istic.master1.doodleplus_back_end.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.master1.doodleplus_back_end.dao.DataAccess;

@Path("/update")
public class PostWebService {
	private DataAccess dao = new DataAccess();
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you now?";
	}
	
	@POST
	@Path("/sondage")
	public void setSondage() {
		dao.setSondage(null, null);
	}
}

package fr.istic.master1.doodleplus_back_end.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.master1.doodleplus_back_end.Createur;
import fr.istic.master1.doodleplus_back_end.dao.DataAccess;

@Path("/update")
public class PostWebService {
	private DataAccess dao = new DataAccess();
		
	@POST
	@Path("/test")
	public void test(Createur test) {
		System.out.println(test.toString());
	}
	
	@POST
	@Path("/test2")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void test(List<Createur> test) {
		for(int i = 0; i < test.size(); i++)
		  System.out.println(test.get(i).toString());
	}
	

	@POST
	@Path("/sondage")
	public void setSondage() {
		dao.setSondage(null, null);
	}
	
}

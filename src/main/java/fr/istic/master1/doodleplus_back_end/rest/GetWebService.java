package fr.istic.master1.doodleplus_back_end.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.master1.doodleplus_back_end.Allergie;
import fr.istic.master1.doodleplus_back_end.Createur;
import fr.istic.master1.doodleplus_back_end.DateSondage;
import fr.istic.master1.doodleplus_back_end.HeureSondage;
import fr.istic.master1.doodleplus_back_end.Participant;
import fr.istic.master1.doodleplus_back_end.Preference;
import fr.istic.master1.doodleplus_back_end.Sondage;
import fr.istic.master1.doodleplus_back_end.dao.DataAccess;

@Path("/select")
public class GetWebService {
	private DataAccess dao = new DataAccess();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
	}
		
	@GET
	@Path("/createur")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Createur> getCreateurs() {
		return dao.getCreateurs();
	}
	
	@GET
	@Path("/sondage")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sondage> getSondages() {
		return dao.getSondages();
	}
	
	@GET
	@Path("/participant")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Participant> getParticipants() {
		return dao.getParticipants();
	}

	@GET
	@Path("/date")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DateSondage> getDates() {
		return dao.getDates();
	}
	
	@GET
	@Path("/heure")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HeureSondage> getHeures() {
		return dao.getHeures();
	}
	
	@GET
	@Path("/allergie")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Allergie> getAllergies() {
		return dao.getAllergies();
	}
	
	@GET
	@Path("/preference")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Preference> getPreferences() {
		return dao.getPreferences();
	}	
}

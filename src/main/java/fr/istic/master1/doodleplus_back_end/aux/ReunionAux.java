package fr.istic.master1.doodleplus_back_end.aux;

import java.util.List;

import fr.istic.master1.doodleplus_back_end.Createur;
import fr.istic.master1.doodleplus_back_end.Sondage;

public class ReunionAux {
	private Createur createur;
	private Sondage sondage;
	private List<DateAux> dates;
	private List<HeureAux> departs;
	private List<HeureAux> fins;
	private List<String> pause;
	private List<String> preferences;
	private List<String> allergies;
	private List<String> participants;
	
	public ReunionAux() {}
	
	public ReunionAux(Createur createur, Sondage sondage, List<DateAux> dates, List<HeureAux> departs, List<HeureAux> fins,
			List<String> pause, List<String> preferences, List<String> allergies, List<String> participants) {
		this.createur = createur;
		this.sondage = sondage;
		this.dates = dates;
		this.departs = departs;
		this.fins = fins;
		this.pause = pause;
		this.preferences = preferences;
		this.allergies = allergies;
		this.participants = participants;
	}

	public Createur getCreateur() {
		return createur;
	}

	public void setCreateur(Createur createur) {
		this.createur = createur;
	}

	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	public List<DateAux> getDates() {
		return dates;
	}

	public void setDates(List<DateAux> dates) {
		this.dates = dates;
	}

	public List<HeureAux> getDeparts() {
		return departs;
	}

	public void setDeparts(List<HeureAux> departs) {
		this.departs = departs;
	}

	public List<HeureAux> getFins() {
		return fins;
	}

	public void setFins(List<HeureAux> fins) {
		this.fins = fins;
	}

	public List<String> getPause() {
		return pause;
	}

	public void setPause(List<String> pause) {
		this.pause = pause;
	}

	public List<String> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<String> preferences) {
		this.preferences = preferences;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

	public List<String> getParticipants() {
		return participants;
	}

	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "ReunionAux [createur=" + createur.toString() + ", sondage=" + sondage.toString() + ", dates=" + dates + ", departs=" + departs
				+ ", fins=" + fins + ", pause=" + pause + ", preferences=" + preferences + ", allergies=" + allergies
				+ ", participants=" + participants + "]";
	}

}

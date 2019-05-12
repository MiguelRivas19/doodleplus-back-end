package fr.istic.master1.doodleplus_back_end;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class DateSondage {
	private Long id;
	
	private Sondage sondage;
	
	private String jour;
	private String pause;
	
	private List<HeureSondage> heures;
	private List<Participant> participants;
	
	public DateSondage() {
	}
	
	public DateSondage(String jour, String pause, Sondage sondage) {
		this.jour = jour;
		this.pause = pause;
		this.sondage = sondage;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	public String getJour() {
		return jour;
	}
	
	public void setJour(String jour) {
		this.jour = jour;
	}
	
	public String getPause() {
		return pause;
	}
	
	public void setPause(String pause) {
		this.pause = pause;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "date", cascade = CascadeType.PERSIST)
	public List<HeureSondage> getHeures() {
		return heures;
	}

	public void setHeures(List<HeureSondage> heures) {
		this.heures = heures;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "date", cascade = CascadeType.PERSIST)
	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	
	public void setHeure(HeureSondage heure) {
		this.heures.add(heure);
	}
	
	public void setParticipant(Participant participant) {
		this.participants.add(participant);
	}

	@Override
	public String toString() {
		return "Date [id=" + id + ", jour=" + jour
				+ ", pause=" + pause + "] " + sondage.toString();
	}

}

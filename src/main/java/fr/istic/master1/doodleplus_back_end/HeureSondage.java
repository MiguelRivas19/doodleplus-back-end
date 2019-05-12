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
public class HeureSondage {
	private Long id;
	
	private DateSondage date;

	private String depart;
	private String fin;
	
	private List<Participant> participants;
	
	public HeureSondage() {
	}
	
	public HeureSondage(String depart, String fin, DateSondage date) {
		this.depart = depart;
		this.fin = fin;
		this.date = date;
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
	public DateSondage getDate() {
		return date;
	}

	public void setDate(DateSondage date) {
		this.date = date;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "heure", cascade = CascadeType.PERSIST)
	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	
	public void setParticipant(Participant participant) {
		this.participants.add(participant);
	}

	@Override
	public String toString() {
		return "Heure [id=" + id + ", depart=" + depart
				+ ", fin=" + fin + "] " + date.toString();
	}

}

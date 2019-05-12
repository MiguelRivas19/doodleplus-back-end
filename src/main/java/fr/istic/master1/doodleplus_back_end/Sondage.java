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
public class Sondage {
	private Long id;

	private Createur createur;
	
	private String intitule;
	private String lieu;
	private String resume;
	
	private List<Participant> participants;
	private List<DateSondage> dates;

	public Sondage() {
	}

	public Sondage(String intitule, String lieu, String resume, Createur createur) {
		this.intitule = intitule;
		this.lieu = lieu;
		this.resume = resume;
		this.createur = createur;
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
	public Createur getCreateur() {
		return createur;
	}

	public void setCreateur(Createur createur) {
		this.createur = createur;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "sondage", cascade = CascadeType.PERSIST)
	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "sondage", cascade = CascadeType.PERSIST)
	public List<DateSondage> getDates() {
		return dates;
	}

	public void setDates(List<DateSondage> dates) {
		this.dates = dates;
	}
	
	public void setParticipant(Participant participant) {
		this.participants.add(participant);
	}
	
	public void setDate(DateSondage date) {
		this.dates.add(date);
	}

	@Override
	public String toString() {
		return "Sondage [id=" + id + ", intitule=" + intitule + ", lieu=" + lieu
				+ ", resume=" + resume + "] " + createur.toString();
	}
	
}

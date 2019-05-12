package fr.istic.master1.doodleplus_back_end;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Participant{
	private Long id;
	
	private String prenom;
	private String nom;
	private String email;
	
	private Sondage sondage;
	private DateSondage date;
	private HeureSondage heure;
	private Allergie allergie;
	private Preference preference;
	
	public Participant() {
	}

	public Participant(String prenom, String nom, String email, Sondage sondage, DateSondage date, HeureSondage heure, Allergie allergie, Preference preference) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.sondage = sondage;
		this.date = date;
		this.heure = heure;
		this.allergie = allergie;
		this.preference = preference;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToOne
	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
	
	@ManyToOne
	public DateSondage getDate() {
		return date;
	}

	public void setDate(DateSondage date) {
		this.date = date;
	}
	
	@ManyToOne
	public HeureSondage getHeure() {
		return heure;
	}

	public void setHeure(HeureSondage heure) {
		this.heure = heure;
	}
	
	@ManyToOne
	public Allergie getAllergie() {
		return allergie;
	}

	public void setAllergie(Allergie allergie) {
		this.allergie = allergie;
	}
	
	@ManyToOne
	public Preference getPreference() {
		return preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}
	
	@Override
	public String toString() {
		return "Participant [id=" + id + "] " + sondage.toString() + " " + date.toString() + " " + heure.toString();
	}
	
}

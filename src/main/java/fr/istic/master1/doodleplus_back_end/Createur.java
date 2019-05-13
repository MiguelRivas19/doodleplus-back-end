package fr.istic.master1.doodleplus_back_end;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

@Entity
public class Createur {
	private Long id;
	
	private String prenom;
	private String nom;
	private String email;
	
	private List<Sondage> sondages = new ArrayList<Sondage>();
	
	public Createur() {
	}
	
	public Createur(String prenom, String nom, String email) {
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
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
	
    @JsonIgnore
	@OneToMany(mappedBy = "createur", cascade = CascadeType.PERSIST)
    public List<Sondage> getSondages(){
		return sondages;
	}
	
	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
	}

	@Override
	public String toString() {
		return "Createur [id=" + id + ", prenom=" + prenom
				+ ", nom=" + nom + ", email=" + email + "]";
	}

}

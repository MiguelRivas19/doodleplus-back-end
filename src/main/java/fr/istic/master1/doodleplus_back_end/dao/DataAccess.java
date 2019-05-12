package fr.istic.master1.doodleplus_back_end.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.master1.doodleplus_back_end.Allergie;
import fr.istic.master1.doodleplus_back_end.Createur;
import fr.istic.master1.doodleplus_back_end.DateSondage;
import fr.istic.master1.doodleplus_back_end.HeureSondage;
import fr.istic.master1.doodleplus_back_end.Participant;
import fr.istic.master1.doodleplus_back_end.Preference;
import fr.istic.master1.doodleplus_back_end.Sondage;

public class DataAccess {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
	private EntityManager manager;
	private EntityTransaction tx;
    
    public DataAccess(){
    	factory = Persistence.createEntityManagerFactory("mysql");
    	manager = factory.createEntityManager();
    	tx = manager.getTransaction();
    }

    public List<Sondage> getSondages(){
        return manager.createQuery("select d from Sondage d", Sondage.class).getResultList();
    }
    
    public List<Createur> getCreateurs(){
        return manager.createQuery("select d from Createur d", Createur.class).getResultList();
    }
    
    public List<Participant> getParticipants(){
        return manager.createQuery("select d from Participant d", Participant.class).getResultList();
    }
    
    public List<DateSondage> getDates(){
        return manager.createQuery("select d from DateSondage d", DateSondage.class).getResultList();
    }   
    
    public List<HeureSondage> getHeures(){
        return manager.createQuery("select d from HeureSondage d", HeureSondage.class).getResultList();
    }   

	public List<Allergie> getAllergies() {
        return manager.createQuery("select d from Allergie d", Allergie.class).getResultList();
	}

	public List<Preference> getPreferences() {
        return manager.createQuery("select d from Preference d", Preference.class).getResultList();
	}
    
    public void setSondage(String createur, String intitule){
        tx.begin();
        manager.persist(new Sondage());
        tx.commit();
    }

}

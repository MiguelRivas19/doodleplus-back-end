package fr.istic.master1.doodleplus_back_end;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.master1.doodleplus_back_end.Createur;
import fr.istic.master1.doodleplus_back_end.Participant;
import fr.istic.master1.doodleplus_back_end.Sondage;

public class JpaTest {
	private EntityManager manager;
	
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	
	public void updateParticipants() {
		List<Participant> participants = manager.createQuery("Select p from Participant p", Participant.class).getResultList();
		List<Sondage> sondages = manager.createQuery("Select s from Sondage s", Sondage.class).getResultList();
		
		sondages.get(0).setParticipants(participants);
		
		manager.persist(sondages.get(0));
		
		
		/*
		h1.setDate(d1);
		h2.setDate(d1);
		h3.setDate(d2);
		/*d1.setHeure(h1);
		d1.setHeure(h2);
		d2.setHeure(h3);
		*/
		/*d1.setParticipant(participants.get(0));
		d1.setParticipant(participants.get(1));
		d1.setParticipant(participants.get(2));
		d2.setParticipant(participants.get(3));
		d2.setParticipant(participants.get(4));
		participants.get(0).setDate(d1);
		participants.get(1).setDate(d1);
		participants.get(2).setDate(d1);
		participants.get(3).setDate(d2);
		participants.get(4).setDate(d2);
		
		/*h1.setParticipant(participants.get(0));
		h1.setParticipant(participants.get(1));
		h2.setParticipant(participants.get(2));
		h3.setParticipant(participants.get(3));
		h3.setParticipant(participants.get(4));
		
		participants.get(0).setHeure(h1);
		participants.get(1).setHeure(h1);
		participants.get(2).setHeure(h2);
		participants.get(3).setHeure(h3);
		participants.get(4).setHeure(h3);		
		
		manager.persist(d1);
		manager.persist(d2);
		manager.persist(h1);
		manager.persist(h2);
		manager.persist(h3);*/	
	}
	
	public void createParticipants() {
		Createur c1 = new Createur("angel","rivas","angel.rivas@etudiant.univ-rennes1.fr");
		Sondage s1 = new Sondage("sondage 1","beaulieu","sondage de test", c1);
		
		DateSondage d1 = new DateSondage("lundi","true",s1);
		DateSondage d2 = new DateSondage("mardi","false",s1);
		
		HeureSondage h1 = new HeureSondage("02:00","03:00",d1);
		HeureSondage h2 = new HeureSondage("03:00","04:00",d1);
		HeureSondage h3 = new HeureSondage("02:00","03:00",d2);
		
		Allergie a1 = new Allergie("cereales", "cereales");
		Allergie a2 = new Allergie("crustaces", "crustaces");
		Allergie a3 = new Allergie("oeufs", "oeufs");
		Allergie a4 = new Allergie("poisson", "poisson");
		Allergie a5 = new Allergie("lait", "lait");
		
		Preference r1 = new Preference("ketchup","ketchup");
		Preference r2 = new Preference("nouille","nouille");
		Preference r3 = new Preference("charcuteri","charcuteri");
		Preference r4 = new Preference("sans sucre","sans sucre");
		Preference r5 = new Preference("soda light","soda light");
		
		Participant p1 = new Participant("miguel","rivas","miguel.rivas@etudiant.univ-rennes1.fr", s1,d1,h1,a1,r1);
		Participant p2 = new Participant("sebastien","kobenans","sebastien.kobenan@etudiant.univ-rennes1.fr", s1,d1,h2,a2,r2);
		Participant p3 = new Participant("abbah","anno","abbah.anno@etudiant.univ-rennes1.fr", s1,d1,h1,a3,r1);
		Participant p4 = new Participant("laeba","talat","laeba.talat@etudiant.univ-rennes1.fr", s1,d2,h3,a1,r1);
		Participant p5 = new Participant("constant","lagnito","constant.lagnito@etudiant.univ-rennes1.fr", s1,d2,h3,a3,r2);
		
		manager.persist(c1);
		manager.persist(s1);
		manager.persist(d1);
		manager.persist(d2);
		manager.persist(h1);
		manager.persist(h2);
		manager.persist(h3);
		
		manager.persist(a1);
		manager.persist(a2);
		manager.persist(a3);
		manager.persist(a4);
		manager.persist(a5);

		manager.persist(r1);
		manager.persist(r2);
		manager.persist(r3);
		manager.persist(r4);
		manager.persist(r5);

		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		manager.persist(p4);
		manager.persist(p5);
	}
	
	public void listCreateurs() {
		List<Createur> createurs = manager.createQuery("Select c from Createur c", Createur.class).getResultList();
		System.out.println("num de createurs : " + createurs.size());
		for (Createur c : createurs) {
			System.out.println("next createur : " + c.toString());
		}
	}
	
	public void listParticipants() {
		List<Participant> participants = manager.createQuery("Select p from Participant p", Participant.class).getResultList();
		System.out.println("num de participants : " + participants.size());
		for (Participant p : participants) {
			System.out.println("next participant : " + p.toString());
		}
	}
	
	public void listSondages() {
		List<Sondage> sondages = manager.createQuery("Select s from Sondage s", Sondage.class).getResultList();
		System.out.println("num de sondage : " + sondages.size());
		for (Sondage s : sondages) {
			System.out.println("next sondage : " + s.toString());
		}
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		/*
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createParticipants();
			test.updateParticipants();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		*/
		//test.listCreateurs();
		test.listSondages();
		test.listParticipants();
		
		manager.close();
		factory.close();
		System.out.println("...done!");
	}
	
}

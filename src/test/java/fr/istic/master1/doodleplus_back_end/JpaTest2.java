package fr.istic.master1.doodleplus_back_end;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.master1.doodleplus_back_end.Createur;
import fr.istic.master1.doodleplus_back_end.Participant;
import fr.istic.master1.doodleplus_back_end.Sondage;

public class JpaTest2 {
	private EntityManager manager;
	
	public JpaTest2(EntityManager manager) {
		this.manager = manager;
	}
	
	public void createParticipants() {
	/*	Createur c1 = new Createur("angel","rivas","angel.rivas@etudiant.univ-rennes1.fr");
		Sondage s1 = new Sondage("sondage 1","beaulieu","sondage de test", c1);
		Participant p1 = new Participant("miguel","rivas","miguel.rivas@etudiant.univ-rennes1.fr", s1);
		Participant p2 = new Participant("sebastien","kobenans","sebastien.kobenan@etudiant.univ-rennes1.fr", s1);
		Participant p3 = new Participant("abbah","anno","abbah.anno@etudiant.univ-rennes1.fr", s1);
		Participant p4 = new Participant("laeba","talat","laeba.talat@etudiant.univ-rennes1.fr", s1);
		Participant p5 = new Participant("constant","lagnito","constant.lagnito@etudiant.univ-rennes1.fr", s1);
		
		manager.persist(c1);
		manager.persist(s1);
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		manager.persist(p4);
		manager.persist(p5);*/
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
		JpaTest2 test = new JpaTest2(manager);
		
		/*EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createParticipants();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();*/
		
		test.listCreateurs();
		test.listSondages();
		test.listParticipants();
		
		manager.close();
		factory.close();
		System.out.println("...done!");
	}
	
}

package fr.istic.master1.doodleplus_back_end;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest3 {
	private EntityManager manager;
	
	public JpaTest3(EntityManager manager) {
		this.manager = manager;
	}
	
	public void createParticipant() {
		Participant p1 = new Participant();
		manager.persist(p1);
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest3 test = new JpaTest3(manager);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createParticipant();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		manager.close();
		factory.close();
		System.out.println("...done!");
	}

}

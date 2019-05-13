package fr.istic.master1.doodleplus_back_end;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest4 {
	private EntityManager manager;
	
	public JpaTest4(EntityManager manager) {
		this.manager = manager;
	}
	
	public void updateParticipants() {
		Sondage s1 = new Sondage();
		
		Participant p1 = manager.createQuery("Select p from Participant p where id = :id", Participant.class)
				.setParameter("id", (long) 11)
				.getSingleResult();
		
		p1.setSondage(s1);

		manager.persist(s1);
		manager.persist(p1);
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest4 test = new JpaTest4(manager);
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.updateParticipants();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
				
		manager.close();
		factory.close();
		System.out.println("...done!");
	}

}

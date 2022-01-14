package be.com.elton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {
	
 private static final EntityManagerFactory emf = 
		 Persistence.createEntityManagerFactory("auto");
 
	public static EntityManager getEntityManager() {
	 return emf.createEntityManager();
 }

}

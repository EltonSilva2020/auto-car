package be.com.elton;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import be.com.elton.Automovel;
import be.com.elton.JPAutil;

public class PersistindoAutomovel {

	public static void main(String[] args) {
		
		EntityManager em = JPAutil.getEntityManager();
		Query q = em.createQuery("select a from Automovel a", Automovel.class);
		
		List<Automovel> autos =  q.getResultList(); 
		
		for (Automovel a : autos) {
			
			System.out.println("Marca: " + a.getMarca());
			
		}
		
		/*Automovel auto = new Automovel();
		auto.setMarca("Lamborguine");
		auto.setAnoFabricacao(2011);
		auto.setObservacoes("esta em bom estado");
		
				
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(auto);
		tx.commit();
		
		em.close();
	*/

	}

}

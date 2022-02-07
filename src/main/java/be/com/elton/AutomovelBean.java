package be.com.elton;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

@ManagedBean
@RequestScoped
public class AutomovelBean {

	private Automovel automovel = new Automovel();

	private List<Automovel> automoveis;
	private Marca marca;

	public List<Automovel> getAutomoveis() {
		if (this.automoveis == null) {
			EntityManager em = JPAutil.getEntityManager();

			Query q = em.createQuery("select a from Automovel a", Automovel.class);
			this.automoveis = q.getResultList();
			em.close();
		}
		return automoveis;

	}
	

	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public void salva(Automovel automovel) {

		EntityManager em = JPAutil.getEntityManager();

		em.getTransaction().begin();
		em.persist(automovel);
		em.getTransaction().commit();

		em.close();
		
		

	}

	public void remove(Automovel automovel) {

		EntityManager em = JPAutil.getEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();
		automovel = em.merge(automovel);
		em.remove(automovel);
		tx.commit();
		em.close();

	}

}

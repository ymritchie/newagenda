package br.com.agenda.persistencia;

import static javax.persistence.Persistence.createEntityManagerFactory;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class GenericDao <T, I extends Serializable> {
	 
	 
	  

	
	
	private static EntityManagerFactory entityManagerFactory = createEntityManagerFactory("AGENDA_JPA");

	private EntityManager em;

	private EntityTransaction transaction;


	private EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
	
	
	public void save(T bean) {
		
		try {
			em = getEntityManager();
			transaction = em.getTransaction();	
			transaction.begin();
			em.merge(bean);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	
	public void delete(T bean) {
		try {
			em = getEntityManager();
			transaction = em.getTransaction();	
			transaction.begin();
			em.remove(em.merge(bean));
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
    }

	
	public T findById(Class<T> classe, I pk) {
		em = getEntityManager();
		T tmp = em.find(classe,pk);
		em.close();
		return tmp;
	}

	@SuppressWarnings("unchecked")
	
	public List<T> listar(Class<T> classe) {
		em = getEntityManager();
		Query query = em.createQuery("select o from " + classe.getSimpleName() + " o");
		List<T> tmp = query.getResultList();
		em.close();
		return  tmp;
	}
}

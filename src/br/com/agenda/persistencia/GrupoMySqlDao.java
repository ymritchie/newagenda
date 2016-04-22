package br.com.agenda.persistencia;

import static javax.persistence.Persistence.createEntityManagerFactory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.agenda.nucleo.Grupo;

public class GrupoMySqlDao implements GrupoDao {
	
	private static EntityManagerFactory entityManagerFactory = createEntityManagerFactory("AGENDA_JPA");
	
	private EntityManager em;
	
	private EntityTransaction transaction;
	
	private EntityManager getEntityManager (){
		return entityManagerFactory.createEntityManager();
	}

	@Override
	public void save(Grupo grupo) {
		try {
			em = getEntityManager();
			transaction = em.getTransaction();
			transaction.begin();
			//em.persist(grupo);
			em.merge(grupo);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public void delete(Grupo grupo) {
		try {
			em = getEntityManager();
			transaction = em.getTransaction();
			transaction.begin();
			grupo = em.merge(grupo);
			em.remove(grupo);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}		
	}

	@Override
	public Grupo findById(Integer id) {
		em = getEntityManager();
		Grupo c = em.find(Grupo.class, id);
		em.close();
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Grupo> listGrupos() {
		em =  getEntityManager();	
		Query query = em.createQuery("from Grupo");
		List<Grupo> tmp = query.getResultList();
		em.close();
		
		return tmp;
	}

}

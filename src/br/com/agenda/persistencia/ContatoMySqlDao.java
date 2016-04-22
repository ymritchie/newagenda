package br.com.agenda.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import static javax.persistence.Persistence.*;

import br.com.agenda.nucleo.Contato;
import br.com.agenda.nucleo.Grupo;

public class ContatoMySqlDao implements ContatoDao{

	private static EntityManagerFactory entityManagerFactory = createEntityManagerFactory("AGENDA_JPA");
	
	private EntityManager em;
	
	private EntityTransaction transaction;
	
	private EntityManager getEntityManager (){
		return entityManagerFactory.createEntityManager();
	}
	
	
	@Override
	public void save(Contato contato) {
		
		try{
			em = getEntityManager();
			transaction = em.getTransaction();
			transaction.begin();
			em.merge(contato);
			//em.persist(contato);
			transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	@Override
	public void delete(Contato contato) {
		try {
			em = getEntityManager();
			transaction = em.getTransaction();
			transaction.begin();
			contato = em.merge(contato);
			em.remove(contato);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
	}

	@Override
	public Contato findById(Integer id) {
		em = getEntityManager();
		Contato c = em.find(Contato.class, id);
		em.close();
		return c;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Contato> listContatos() {
		em =  getEntityManager();	
		Query query = em.createNamedQuery("Contato.listAll");
		List<Contato> tmp = query.getResultList();
		em.close();
		
		return tmp;
	}

	@Override
	public List<Grupo> listGrupos() {
		return null;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Contato> listFavoritos(boolean isFavorito) {
		em = getEntityManager();
		Query query = em.createQuery("from Contato c where c.favorito = :favorito and c.aniversario = :aniver");
		query.setParameter("favorito", isFavorito);
		List<Contato> tmp = query.getResultList();
		em.close();
		return tmp;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Contato> listPorGrupo(Grupo g) {
		em = getEntityManager();
		Query query = em.createQuery("from Contato c where c.grupo = :grupo");
		query.setParameter("grupo", g);
		List<Contato> tmp = query.getResultList();
		em.close();
		return tmp;
	}

}

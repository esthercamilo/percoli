package br.unesp.ibb.lbbc.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BasicService {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction transaction;
	private static BasicService instance = null;

	static {
		instance = new BasicService();
	}

	private BasicService() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("PERCOLI");
	}

	public static BasicService getInstance() {
		if (instance == null ) {
			instance = new BasicService();
		}
		return instance;
	}

	public EntityManager getEntityManager(){
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	
	EntityTransaction getTransaction() {
		if (transaction == null || !transaction.isActive()) {
			transaction = entityManager.getTransaction();
		}
		return transaction;
	}

}

package net.gezinsbondouwegem.services;

import javax.persistence.EntityManager;

import net.gezindsbondouwegem.filters.JPAFilter;

public class AbstractService {
	private EntityManager getEntityManager() {
		return JPAFilter.getEntityManager();
	}

	protected void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	protected void commit() {
		getEntityManager().getTransaction().commit();
	}

	protected void rollback() {
		getEntityManager().getTransaction().rollback();
	}	

}

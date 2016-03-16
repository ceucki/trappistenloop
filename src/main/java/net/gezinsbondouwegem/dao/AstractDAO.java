package net.gezinsbondouwegem.dao;

import javax.persistence.EntityManager;

public class AstractDAO {
	protected EntityManager getEntityManager() { 
		 return net.gezindsbondouwegem.filters.JPAFilter.getEntityManager(); 
		 }
}

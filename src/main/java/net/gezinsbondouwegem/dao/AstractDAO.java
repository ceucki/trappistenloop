package net.gezinsbondouwegem.dao;

import javax.persistence.EntityManager;

import net.gezindsbondouwegem.filters.JPAFilter;

public class AstractDAO {
	protected EntityManager getEntityManager() { 
		 return JPAFilter.getEntityManager(); 
		 }
}

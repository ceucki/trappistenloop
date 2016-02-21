package net.gezinsbondouwegem.dao;

import net.gezinsbondouwegem.entities.Persoon;

public class PersoonDAO extends AstractDAO{
	
	public Persoon read(long id) {
		return getEntityManager().find(Persoon.class, id);
		 }
	
	public void create(Persoon persoon) {
		 getEntityManager().persist(persoon);
		 }

}

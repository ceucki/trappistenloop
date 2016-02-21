package net.gezinsbondouwegem.dao;

import java.util.List;

import net.gezinsbondouwegem.entities.Activiteit;

public class ActiviteitDAO extends AstractDAO{

	public Activiteit read(long id) {
		return getEntityManager().find(Activiteit.class, id);	
	}
	
	public void create(Activiteit activiteit) {
		 getEntityManager().persist(activiteit);
		}
	
	public List<Activiteit> findActiviteiten() {
		 return getEntityManager().createNamedQuery("Activiteit.findAll", Activiteit.class).getResultList();
		}

}

package net.gezinsbondouwegem.dao;

import java.util.List;

import net.gezinsbondouwegem.entities.Persoon;

public class PersoonDAO extends AstractDAO {

	public Persoon read(long id) {
		return getEntityManager().find(Persoon.class, id);
	}

	public void create(Persoon persoon) {
		getEntityManager().persist(persoon);
	}

	public List<Persoon> findActiviteiten() {
		return getEntityManager().createNamedQuery("Persoon.findAll", Persoon.class).getResultList();
	}
}

package net.gezinsbondouwegem.services;

import java.util.List;

import net.gezinsbondouwegem.dao.PersoonDAO;
import net.gezinsbondouwegem.entities.Activiteit;
import net.gezinsbondouwegem.entities.Persoon;

public class PersoonService extends AbstractService {
	private final PersoonDAO persoonDAO = new PersoonDAO();

	public Persoon read(long id) {
		return persoonDAO.read(id);
	}

	public void create(Persoon persoon) {
		beginTransaction();
		persoonDAO.create(persoon);
		commit();
	}
	
	public List<Persoon> findAllePersonen() {
		 return persoonDAO.findActiviteiten();
		}
}

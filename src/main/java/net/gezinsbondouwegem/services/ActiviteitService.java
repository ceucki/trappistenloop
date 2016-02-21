package net.gezinsbondouwegem.services;

import java.util.List;

import net.gezinsbondouwegem.dao.ActiviteitDAO;
import net.gezinsbondouwegem.entities.Activiteit;

public class ActiviteitService extends AbstractService{

	private final ActiviteitDAO activiteitDAO = new ActiviteitDAO();

	public Activiteit read(long id) {
		return activiteitDAO.read(id);
	}

	public void create(Activiteit activiteit) {
		beginTransaction();
		activiteitDAO.create(activiteit);
		commit();
	}
	public List<Activiteit> findAlleActiviteiten() {
		 return activiteitDAO.findActiviteiten();
		}

}

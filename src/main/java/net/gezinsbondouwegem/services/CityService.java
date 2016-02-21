package net.gezinsbondouwegem.services;

import java.util.List;

import net.gezinsbondouwegem.dao.CityDAO;
import net.gezinsbondouwegem.entities.City;

public class CityService extends AbstractService {

	private final CityDAO cityDAO = new CityDAO();

	public List<City> findAll() {
		return cityDAO.findAll();
	}
}

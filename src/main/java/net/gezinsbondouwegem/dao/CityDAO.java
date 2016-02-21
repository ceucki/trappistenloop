package net.gezinsbondouwegem.dao;

import java.util.List;

import net.gezinsbondouwegem.entities.City;

public class CityDAO extends AstractDAO{
	
	public List<City> findAll()
	{
		return getEntityManager().createNamedQuery("City.findAll", City.class).getResultList();
	}
}

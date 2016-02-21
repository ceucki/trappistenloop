package net.gezinsbondouwegem.services;

import java.util.List;

import net.gezinsbondouwegem.dao.AdresDAO;
import net.gezinsbondouwegem.entities.Adres;

public class AdresService extends AbstractService{
	
	private final AdresDAO adresDAO = new AdresDAO();

	public Adres read(long id) {
		return adresDAO.read(id);
	}

	public void create(Adres adres) {
		beginTransaction();
		adresDAO.create(adres);
		commit();
	}
	public List<Adres> findAlleAdressen() {
		 return adresDAO.findAdressen();
		}

}

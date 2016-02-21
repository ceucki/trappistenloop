package net.gezinsbondouwegem.dao;

import java.util.List;

import net.gezinsbondouwegem.entities.Adres;

public class AdresDAO extends AstractDAO{
	
	public Adres read(long id) {
		return getEntityManager().find(Adres.class, id);	
	}	
	
	public void create(Adres adres) {
		 getEntityManager().persist(adres);
		}
	
	public List<Adres> findAdressen() {
		 return getEntityManager().createNamedQuery("Adres.findAll", Adres.class).getResultList();
		}

}

package net.gezinsbondouwegem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adres")
public class Adres implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAdres;
	@Column(name = "straat")
	private String straat;
	@Column(name = "huisNr")
	private String huisNr;
	@Column(name = "gemeente")
	private String gemeente;
	@Column(name = "postcode")
	private String postcode;

	public Adres() {
	};
	
	public Adres(String straat, String huisNr, String postcode, String gemeente) {
		setStraat(straat);
		setHuisNr(huisNr);
		setGemeente(gemeente);
		setPostcode(postcode);
	};

	public long getId() {
		return idAdres;
	}

	public void setId(long id) {
		this.idAdres = id;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}

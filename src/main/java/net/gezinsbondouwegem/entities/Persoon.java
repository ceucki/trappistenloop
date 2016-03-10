package net.gezinsbondouwegem.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persoon")
public class Persoon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPersoon;
	@Column(name = "Naam")
	private String Naam;
	@Column(name = "Voornaam")
	private String Voornaam;
	@Column(name = "TelefoonNr")
	private String TelefoonNr;
	@Column(name = "email")
	private String Email;
	
	@Column(name="datum")
	private Date datum;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="idAdres")
	private Adres adres;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="idActiviteit")
	private Activiteit activiteit;



	public Adres getAdres() {
		return adres;
	}
	
	public Date getDatum() {
		return datum;
	}



	public void setDatum(Date datum) {
		this.datum = datum;
	}



	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public Activiteit getActiviteit() {
		return activiteit;
	}

	public void setActiviteit(Activiteit activiteit) {
		this.activiteit = activiteit;
	}
	
	public Persoon(){}

	public Persoon(String voornaam, String familienaam, String email,
			String telefoonNr, Date date) {
		setEmail(email);
		setNaam(familienaam);
		setTelefoonNr(telefoonNr);
		setVoornaam(voornaam);
		setDatum(date);
	}

	public static boolean isVoornaamValid(String voornaam) {
		return voornaam != null && !voornaam.isEmpty();
	}

	public static boolean isFamilienaamValid(String familienaam) {
		return familienaam != null && !familienaam.isEmpty();
	}	

	public long getId() {
		return idPersoon;
	}

	public void setId(long id) {
		this.idPersoon = id;
	}

	public String getNaam() {	

		return Naam;
	}

	public void setNaam(String naam) {
		if (!isFamilienaamValid(naam)) {
			throw new IllegalArgumentException();
		}
		this.Naam = naam;
	}

	public String getVoornaam() {
		return Voornaam;
	}

	public void setVoornaam(String voornaam) {
		if (!isVoornaamValid(voornaam)) {
			throw new IllegalArgumentException();
		}
		this.Voornaam = voornaam;
	}

	public String getTelefoonNr() {
		return TelefoonNr;
	}

	public void setTelefoonNr(String telefoonNr) {
		TelefoonNr = telefoonNr;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getVolledigeNaam() {
		return Voornaam + " " + Naam;
	}

}

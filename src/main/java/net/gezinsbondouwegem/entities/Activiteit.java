package net.gezinsbondouwegem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activiteit")
public class Activiteit implements Serializable {

	/**
	 * 		
	 */
	private static final long serialVersionUID = 1L;
	
	public Activiteit() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idActiviteit;
	
	@Column(name="activiteit")
	private String activiteit;
	
	@Column(name="prijs")
	private double prijs;	

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public long getId() {
		return idActiviteit;
	}

	public void setId(long id) {
		this.idActiviteit = id;
	}

	public String getActiviteit() {
		return activiteit;
	}

	public void setActiviteit(String activiteit) {
		this.activiteit = activiteit;
	}

}

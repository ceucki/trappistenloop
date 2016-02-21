package net.gezinsbondouwegem.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City implements Serializable{

	public long getIdcities() {
		return idcities;
	}

	public void setIdcities(long idcities) {
		this.idcities = idcities;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUp() {
		return up;
	}

	public void setUp(String up) {
		this.up = up;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idcities;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@Column(name="name")
	private String name;
	
	@Column(name="up")
	private String up;
	
	@Column(name="structure")
	private String structure;	

}
		
package com.compta.compta.model;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "journal")
public class Journal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	 private int code_JRN;
	 private long code_soc;
	  private String libelle;
	  private String type_JRN;
	  
	/*  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	  private Ecriture ecriture;*/
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public int getCode_JRN() {
		return code_JRN;
	}

	public void setCode_JRN(int code_JRN) {
		this.code_JRN = code_JRN;
	}

	

	public long getCode_soc() {
		return code_soc;
	}

	public void setCode_soc(long code_soc) {
		this.code_soc = code_soc;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getType_JRN() {
		return type_JRN;
	}

	public void setType_JRN(String type_JRN) {
		this.type_JRN = type_JRN;
	}


	


	

	public Journal() {
		super();
	}

	public Journal(long id, int code_JRN, long code_soc, String libelle, String type_JRN, Ecriture ecriture) {
		super();
		this.id = id;
		
		this.code_JRN = code_JRN;
		this.code_soc = code_soc;
		this.libelle = libelle;
		this.type_JRN = type_JRN;
		
	}

	@Override
	public String toString() {
		return "Journal [id=" + id + ", code_JRN=" + code_JRN + ", code_soc=" + code_soc
				+ ", libelle=" + libelle + ", type_JRN=" + type_JRN + "]";
	}

	
	 
	  
}

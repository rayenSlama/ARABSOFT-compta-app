package com.compta.compta.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "devise")
public class Devis {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private int annee_devise;
	  private String code_devise;
	  private String libelle_devise;
	  private float taux;
	  
	  
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAnnee_devise() {
		return annee_devise;
	}
	public void setAnnee_devise(int annee_devise) {
		this.annee_devise = annee_devise;
	}
	public String getCode_devise() {
		return code_devise;
	}
	public void setCode_devise(String code_devise) {
		this.code_devise = code_devise;
	}
	public String getLibelle_devise() {
		return libelle_devise;
	}
	public void setLibelle_devise(String libelle_devise) {
		this.libelle_devise = libelle_devise;
	}
	public float getTaux() {
		return taux;
	}
	public void setTaux(float taux) {
		this.taux = taux;
	}
	public Devis(long id, int annee_devise, String code_devise, String libelle_devise, float taux) {
		super();
		this.id = id;
		this.annee_devise = annee_devise;
		this.code_devise = code_devise;
		this.libelle_devise = libelle_devise;
		this.taux = taux;
	}
	public Devis() {
		super();
	}
	
}

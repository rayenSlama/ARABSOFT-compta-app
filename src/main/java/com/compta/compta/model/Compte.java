package com.compta.compta.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "compte")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	
	 private String numcompte;
	 private int code_soc;
	  private String libellec;
	  private Date datecreation;
	/*  private boolean bloque;*/
	  private String codetier;
	  private String code;
	  private String lib_tier;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumcompte() {
		return numcompte;
	}
	public void setNumcompte(String numcompte) {
		this.numcompte = numcompte;
	}
	public int getCode_soc() {
		return code_soc;
	}
	public void setCode_soc(int code_soc) {
		this.code_soc = code_soc;
	}
	public String getLibellec() {
		return libellec;
	}
	public void setLibellec(String libellec) {
		this.libellec = libellec;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	/*public boolean isBloque() {
		return bloque;
	}
	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}*/
	public String getCodetier() {
		return codetier;
	}
	public void setCodetier(String codetier) {
		this.codetier = codetier;
	}
	public String getLib_tier() {
		return lib_tier;
	}
	public void setLib_tier(String lib_tier) {
		this.lib_tier = lib_tier;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Compte(long id, String numcompte,String code, int code_soc, String libellec, Date datecreation,/* boolean bloque,*/ String codetier,
			String lib_tier) {
		super();
		this.id = id;
		this.numcompte = numcompte;
		this.code_soc = code_soc;
		this.libellec = libellec;
		this.datecreation = datecreation;
		/*this.bloque = bloque;*/
		this.codetier = codetier;
		this.lib_tier = lib_tier;
		this.code=code;
	}
	public Compte() {
		super();
	}
	
	
}

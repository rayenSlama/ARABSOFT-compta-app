package com.compta.compta.model;


import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import javax.validation.constraints.Email;
@Entity
@Table(name = "fournisseur")
@DiscriminatorValue("fournisseur")
public class Fournisseur extends Tiers {
	 @NotBlank
		@Size(max = 60)
	  private String libelle;
	  private String code;
		@Size(min = 5)
	  private String adresse;
	private int codetier;
	  private String ville;	
	  @Size(min = 8)
	  private String tel;
	  @Email
	  private String email;
	  private String fax;
	  @Size(min = 5)
	  private String login;
	  private String pwd;
	  private String  matfisc;
	
	private Date cree;
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getLogin() {
		return login;
	}
	
	public int getCodetier() {
		return codetier;
	}
	public void setCodetier(int codetier) {
		this.codetier = codetier;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMatfisc() {
		return matfisc;
	}
	public void setMatfisc(String matfisc) {
		this.matfisc = matfisc;
	}

	public Date getCree() {
		return cree;
	}
	public void setCree(Date cree) {
		this.cree = cree;
	}
	
	public Fournisseur(long id, String libelle,int codetier, String code, String adresse, String ville, String tel, String email,
			String fax, String login, String pwd, String matfisc,Date cree) {
		super(id);
		this.libelle = libelle;
		this.code = code;
		this.adresse = adresse;
		this.ville = ville;
		this.tel = tel;
		this.email = email;
		this.fax = fax;
		this.login = login;
		this.pwd = pwd;
		this.matfisc = matfisc;
		this.cree=cree;
		this.codetier=codetier;
	}
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	
}
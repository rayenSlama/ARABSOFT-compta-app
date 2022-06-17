package com.compta.compta.model;
import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name = "client")
@DiscriminatorValue("Client")
public class Client extends Tiers {
	
	  private String code;
	  private int codetier;
	  @NotBlank
		@Size(max = 60)
	  private String libelle;
	  @NotBlank
		@Size(min = 5)
	  private String adresse;
	  @Size(min = 8)
	  private String tel;
	  @Email
	  private String email;
	  @Size(min = 8)
	  private String fax;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public int getCodetier() {
		return codetier;
	}
	public void setCodetier(int codetier) {
		this.codetier = codetier;
	}
	public Client(long id, String code,int codetier, String libelle, String adresse, String tel, String email, String fax, String login,
			String pwd, String matfisc, Date cree) {
		super(id);
		this.code = code;
		this.libelle = libelle;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.fax = fax;
		this.login = login;
		this.pwd = pwd;
		this.matfisc = matfisc;
		this.cree = cree;
		this.codetier=codetier;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
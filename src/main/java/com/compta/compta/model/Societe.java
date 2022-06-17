package com.compta.compta.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "societe")
public class Societe {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  private String libelle;
	  private String slibelle;
	  private String adresse;
	  private String tel1;
	  private String tel2;
	  private String fax;
	  private String matf;
	  private String rib;
	  private String banque;
	  private int numc;
	  private int numf;
	  private String Abrevc;
	  private String Abrevf;
	  private String registre;
	  private int rang;
	  private int rangg;
	  private int ranglig;
	  private String image;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getSlibelle() {
		return slibelle;
	}
	
	public int getRanglig() {
		return ranglig;
	}
	public void setRanglig(int ranglig) {
		this.ranglig = ranglig;
	}
	public void setSlibelle(String slibelle) {
		this.slibelle = slibelle;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public int getRangg() {
		return rangg;
	}
	public void setRangg(int rangg) {
		this.rangg = rangg;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getMatf() {
		return matf;
	}
	public void setMatf(String matf) {
		this.matf = matf;
	}
	public String getRib() {
		return rib;
	}
	public void setRib(String rib) {
		this.rib = rib;
	}
	public String getBanque() {
		return banque;
	}
	public void setBanque(String banque) {
		this.banque = banque;
	}
	public int getNumc() {
		return numc;
	}
	public void setNumc(int numc) {
		this.numc = numc;
	}
	public int getNumf() {
		return numf;
	}
	public void setNumf(int numf) {
		this.numf = numf;
	}
	
	
	public int getRang() {
		return rang;
	}
	public void setRang(int rang) {
		this.rang = rang;
	}
	public String getAbrevc() {
		return Abrevc;
	}
	public void setAbrevc(String abrevc) {
		Abrevc = abrevc;
	}
	public String getAbrevf() {
		return Abrevf;
	}
	public void setAbrevf(String abrevf) {
		Abrevf = abrevf;
	}
	public String getRegistre() {
		return registre;
	}
	public void setRegistre(String registre) {
		this.registre = registre;
	}
	
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Societe(long id, String libelle, String slibelle, String adresse, String tel1, String tel2, String fax,
			String matf, String rib,int rang,int rangg,int ranglig, String banque,String image, int numc, int numf, String abrevc, String abrevf, String registre) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.slibelle = slibelle;
		this.adresse = adresse;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.fax = fax;
		this.matf = matf;
		this.rib = rib;
		this.banque = banque;
		this.numc = numc;
		this.numf = numf;
		this.rang=rang;
		this.ranglig=ranglig;
		this.rangg=rangg;
		Abrevc = abrevc;
		Abrevf = abrevf;
		this.registre = registre;
		this.image=image;
	}
	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Societe [id=" + id + ", libelle=" + libelle + ", slibelle=" + slibelle + ", adresse=" + adresse
				+ ", tel1=" + tel1 + ", tel2=" + tel2 + ", fax=" + fax + ", matf=" + matf + ", rib=" + rib + ", banque="
				+ banque + ",ranglig=" + ranglig + ", numc=" + numc + ", image=" + image + ", numf=" + numf + ", rang=" + rang + ", Abrevc=" + Abrevc + ", Abrevf=" + Abrevf
				+ ", registre=" + registre + "]";
	}
	
	
	
	
	
	
	
}

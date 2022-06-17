package com.compta.compta.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "ecriture")
public class Ecriture {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	private int annee;
	  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT")
	  private Date date_ecrt;
      private String codetier;
      private String code;
      private int code_JRN;
      private String lib_tier;
      private int numecrt;
    
    
     
      private String num_piece;
   
      private String libelle;
      private char sens;
      private float montant;
      private float totdeb;
      private float totcred;
      private float solde;
      private int lig;
   
      private String numcompte;
      private String libellec;
      private float taux;
   
      private String code_devise;
      @JsonManagedReference
	 /* @JsonIgnore*/
	  @OneToMany(mappedBy = "ecriture"/*, fetch=FetchType.EAGER*/,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
      @Valid
	  private List<LigneEcriture> lecritures = new ArrayList<>();

      
      
      
      
    
	public int getCode_JRN() {
		return code_JRN;
	}
	public void setCode_JRN(int code_JRN) {
		this.code_JRN = code_JRN;
	}
	
	public List<LigneEcriture> getLecritures() {
		return lecritures;
	}
	public void setLecritures(List<LigneEcriture> lecritures) {
		this.lecritures = lecritures;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodetier() {
		return codetier;
	}
	public void setCodetier(String codetier) {
		this.codetier = codetier;
	}
	

	
	public String getLibellec() {
		return libellec;
	}
	public void setLibellec(String libellec) {
		this.libellec = libellec;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNum_piece() {
		return num_piece;
	}
	public void setNum_piece(String num_piece) {
		this.num_piece = num_piece;
	}
	public String getNumcompte() {
		return numcompte;
	}
	public void setNumcompte(String numcompte) {
		this.numcompte = numcompte;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public char getSens() {
		return sens;
	}
	public void setSens(char sens) {
		this.sens = sens;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	
	public String getLib_tier() {
		return lib_tier;
	}
	public void setLib_tier(String lib_tier) {
		this.lib_tier = lib_tier;
	}
	
	public int getNumecrt() {
		return numecrt;
	}
	public void setNumecrt(int numecrt) {
		this.numecrt = numecrt;
	}
	public float getTotdeb() {
		return totdeb;
	}
	public void setTotdeb(float totdeb) {
		this.totdeb = totdeb;
	}
	public float getTotcred() {
		return totcred;
	}
	public void setTotcred(float totcred) {
		this.totcred = totcred;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	
	
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public Date getDate_ecrt() {
		return date_ecrt;
	}
	public void setDate_ecrt(Date date_ecrt) {
		this.date_ecrt = date_ecrt;
	}
	public Ecriture() {
		super();
	
	
	}
	public float getTaux() {
		return taux;
	}
	public void setTaux(float taux) {
		this.taux = taux;
	}
	public String getCode_devise() {
		return code_devise;
	}
	public void setCode_devise(String code_devise) {
		this.code_devise = code_devise;
	}
	
	
	
	public int getLig() {
		return lig;
	}
	public void setLig(int lig) {
		this.lig = lig;
	}
	public Ecriture(long id, int annee,int lig, Date date_ecrt, String codetier, int code_JRN, String lib_tier, int numecrt,  String num_piece, String libelle, char sens, float montant, float totdeb,
			float totcred,String libellec,String code, float solde, float taux,String code_devise, String numcompte, @Valid List<LigneEcriture> lecritures) {
		super();
		this.id = id;
		this.annee = annee;
		this.date_ecrt = date_ecrt;
		this.codetier = codetier;
		this.code_JRN = code_JRN;
		this.lib_tier = lib_tier;
		this.numecrt = numecrt;
		this.code=code;
		this.libellec=libellec;
	
		this.num_piece = num_piece;
		this.libelle = libelle;
		this.sens = sens;
		this.montant = montant;
		this.totdeb = totdeb;
		this.totcred = totcred;
		this.solde = solde;
		this.taux=taux;
		this.lig=lig;
		this.code_devise=code_devise;
		this.numcompte = numcompte;
		this.lecritures = lecritures;
	}
	@Override
	public String toString() {
		return "Ecriture [id=" + id + ", annee=" + annee + ", date_ecrt=" + date_ecrt + ", codetier=" + codetier
				+ ", code_JRN=" + code_JRN + ", lib_tier=" + lib_tier + ", num_ecrt=" + numecrt + ", num_piece=" + num_piece + ", libelle=" + libelle
				+ ", sens=" + sens + ", montant=" + montant + ", totdeb=" + totdeb + ", totcred=" + totcred + ", solde="
				+ solde + ",libellec=" + libellec + ", numcompte=" + numcompte + ", code=" + code + " taux=" + taux + ",code_devise=" +code_devise+ ", lecritures=" + lecritures + "]";
	}
	
	
	
}

package com.compta.compta.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ligneEcriture")
/*@SequenceGenerator(name="lig" ,initialValue=1, allocationSize=100)*/
public class LigneEcriture {

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	  @Column(name="numero")
	  private int numero ;
	 /* @GeneratedValue(strategy =GenerationType.SEQUENCE, generator="lig")*/
	  private int lig;
	
	  private String num_piece;
	 
	  private String numcompte;
	 /* private String lib_ecrt;
	  private int code_JRN;*/
	  private String code;
	  private char sens;
	/*  private char aux;*/
	  private String codetier;
	  private String lib_tier;
	  private String libellec;
	  private float montant;
	  private int annee;
	  private float solde;
	  private float totcred;
	  private float totdeb;
	  
	  @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	  @JoinColumn(name="ecriture_id")
	  private Ecriture ecriture;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getLig() {
		return lig;
	}
	public void setLig(int lig) {
		this.lig = lig;
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
	public String getNum_piece() {
		return num_piece;
	}
	
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public char getSens() {
		return sens;
	}
	public void setSens(char sens) {
		this.sens = sens;
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
	/*public String getLib_ecrt() {
		return lib_ecrt;
	}
	public void setLib_ecrt(String lib_ecrt) {
		this.lib_ecrt = lib_ecrt;
	}
	public int getCode_JRN() {
		return code_JRN;
	}
	public void setCode_JRN(int code_JRN) {
		this.code_JRN = code_JRN;
	}*/
	public String getLib_tier() {
		return lib_tier;
	}
	public void setLib_tier(String lib_tier) {
		this.lib_tier = lib_tier;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public float getTotcred() {
		return totcred;
	}
	public void setTotcred(float totcred) {
		this.totcred = totcred;
	}
	public float getTotdeb() {
		return totdeb;
	}
	public void setTotdeb(float totdeb) {
		this.totdeb = totdeb;
	}
	public Ecriture getEcriture() {
		return ecriture;
	}
	public void setEcriture(Ecriture ecriture) {
		this.ecriture = ecriture;
	}
	
	
	
	/*public char getAux() {
		return aux;
	}
	public void setAux(char aux) {
		this.aux = aux;
	}*/
	
	public LigneEcriture() {
		super();
	}
	public LigneEcriture(long id, int numero, int lig, String num_piece,String code, String numcompte, char sens, String codetier,int annee, String lib_tier, float montant,String libellec, float solde, float totcred,
			float totdeb, Ecriture ecriture) {
		super();
		this.id = id;
		this.numero = numero;
		this.lig = lig;
		this.num_piece = num_piece;
		this.numcompte = numcompte;
		/*this.lib_ecrt = lib_ecrt;
		this.code_JRN = code_JRN;*/
		this.annee=annee;
		this.sens = sens;
		this.libellec=libellec;
		this.codetier = codetier;
		this.lib_tier = lib_tier;
		this.montant = montant;
		this.solde = solde;
		this.totcred = totcred;
		this.totdeb = totdeb;
		this.ecriture = ecriture;
		this.code=code;
	}
	  
	  
	  
}

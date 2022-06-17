package com.compta.compta.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compteur")
public class Compteur {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	private int annee;
/*	private int numcomm;*/
	private int numecrt;
	private int lig;
	private int numcomms;
	/*private int numbl;
	private int numblf;
	private int numcommf;
	private int numav;
	private int numavf;
	private int numbr;
	private int numbs;
	private int numfac;
	private int numfacf;
	private int numreg;
	private int numregf;
	private int numchq;
	private int numdev;
	private int numinv;
	private int numimp;
	private int numimpf;*/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
public int getLig() {
		return lig;
	}
	public void setLig(int lig) {
		this.lig = lig;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public int getNumecrt() {
		return numecrt;
	}
	public void setNumecrt(int numecrt) {
		this.numecrt = numecrt;
	}
	public int getNumcomms() {
		return numcomms;
	}
	public void setNumcomms(int numcomms) {
		this.numcomms = numcomms;
	}
	
	public Compteur(long id, int annee,int lig, int numecrt, int numcomms) {
		super();
		this.id = id;
		this.annee = annee;
		this.numecrt = numecrt;
	this.lig = lig;
		this.numcomms = numcomms;
		
	}
	
	
	public Compteur() {
		super();
	}
	
	
}
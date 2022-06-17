package com.compta.compta.model;

import java.sql.Date;

import javax.persistence.CascadeType;
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
@Table(name = "Exercice")
public class Exercice_comptable {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	
	/*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference*/
	
	  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JsonBackReference
	  private User user;
	  private String annee;
	  private String date_debut;
	  private String date_fin;
	private char clot;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public char getClot() {
		return clot;
	}
	public void setClot(char clot) {
		this.clot = clot;
	}
	public Exercice_comptable(long id, String annee, String date_debut, String date_fin, char clot) {
		super();
		this.id = id;
		
		this.annee = annee;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.clot = clot;
	}
	public Exercice_comptable() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Exercice_comptable(long id, User user, String annee, String date_debut, String date_fin,
			char clot) {
		super();
		this.id = id;

		this.user = user;
		this.annee = annee;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.clot = clot;
	}
	@Override
	public String toString() {
		return "Exercice_comptable [id=" + id + ", user=" + user + ", annee=" + annee
				+ ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", clot=" + clot + "]";
	}
	
	
}

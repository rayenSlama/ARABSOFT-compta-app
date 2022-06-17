package com.compta.compta.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "tiers")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="TYPE")
public abstract class Tiers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Tiers(long id) {
		super();
		this.id = id;
	}

	public Tiers() {
		super();
	}
	
	

	  
	  
}

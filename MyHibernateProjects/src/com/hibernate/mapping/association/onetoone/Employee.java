package com.hibernate.mapping.association.onetoone;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="EMPLOYEE_ADDR")
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToOne
	//@OneToMany    this gives an error - Illegal attempt to map a non collection as a @OneToMany, @ManyToMany or @CollectionOfElements:
	@JoinColumn(name="ADR_ID")  //Col ADR_ID will hold PK values of Address table. 
	private Address adr;
	
	public void setAdr(Address adr) {
		this.adr = adr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}

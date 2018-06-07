package com.hibernate.embedding.twoaddress;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="EMPLOYEE_ADDR_EMBEDDED2")
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name = "Home_City"), name = "city"),
		@AttributeOverride(column = @Column(name = "Home_State"), name = "state")
	})
	private Address home_address;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name = "Off_City"), name = "city"),
		@AttributeOverride(column = @Column(name = "Off_State"), name = "state")
	})
	private Address off_address;
	

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
	public Address getHome_address() {
		return home_address;
	}
	public void setHome_address(Address home_address) {
		this.home_address = home_address;
	}
	public Address getOff_address() {
		return off_address;
	}
	public void setOff_address(Address off_address) {
		this.off_address = off_address;
	}


}

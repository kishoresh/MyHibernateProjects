package com.hibernate.second;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity 
@Cacheable(true)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region="hibernate.cfg.xml")
@Table (name="EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name="OFF_CITY"), name = "city"),
		@AttributeOverride(column = @Column(name="OFF_STATE"), name = "state")
	})
	private Address off_address;
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name="HOME_CITY"), name = "city"),
		@AttributeOverride(column = @Column(name="HOME_STATE"), name = "state")
	})
	private Address home_address;

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
	public Address getOff_address() {
		return off_address;
	}
	public void setOff_address(Address off_address) {
		this.off_address = off_address;
	}
	public Address getHome_address() {
		return home_address;
	}
	public void setHome_address(Address home_address) {
		this.home_address = home_address;
	}
	

}

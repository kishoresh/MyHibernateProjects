package com.hibernate.mapping.association.manytoone;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="EMPLOYEE_MTO")
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@ManyToOne  //A separate table EMPLOYEE_ADDR_OTM_ADDRESS gets created with 2 cols Employee_id & Address_id	 
//	private Collection<Address> address = new ArrayList<Address>();
	private Address addrr = new Address();
	
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
//	public Collection<Address> getAddress() {
//		return address;
//	}
//	public void setAddress(Collection<Address> address) {
//		this.address = address;
//	}
	public Address getAddr() {
		return addrr;
	}
	public void setAddr(Address addr) {
		this.addrr = addr;
	}
}

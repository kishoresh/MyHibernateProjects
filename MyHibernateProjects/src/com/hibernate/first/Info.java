package com.hibernate.first;
/*
 * Here Address is Embeddable not an Entity. Address is stored as a collection of objects within Info.
 * The output of collection objects is generated in a separate table.
 */
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="Employee_First")
public class Info {
	@Id 
	@GeneratedValue
	private int id;
	private String name;
	
	@ElementCollection
	@JoinTable (name="User_Address", joinColumns=@JoinColumn(name="User_ID"))
	@GenericGenerator (name="seq-gen", strategy="sequence")
	@CollectionId(columns={@Column(name="Address_ID")}, generator="seq-gen", type=@Type(type="long"))
	private Collection<Address> listofAddress = new ArrayList<Address>();
	
	public Collection<Address> getListofAddress() {
		return listofAddress;
	}
	public void setListofAddress(Collection<Address> listofAddress) {
		this.listofAddress = listofAddress;
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

package com.hibernate.mapping.collections;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table (name="EMPLOYEE_COLL")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	//@ElementCollection(fetch=FetchType.EAGER)     //By default fetchtype = lazy, which means the 
	@ElementCollection                              
	//This will create a separate table Employee_listOfAddress 
	//with a PK Employee_id, and all the fields defined in the Address class. This is not user freindly.
	//So to change the name of the table and also the join col name (by default it is created as Employee_ID) we can use
	@JoinTable(name="Employee_Address", joinColumns=@JoinColumn(name="Emp_id"))
	/*
	 * Now Employee_Address does not have a unique id. So use @CollectionId to create a unique id. It takes 3 parameters :
	 * 1st is the col name of the PK field, 2nd defines how the unique value is generated and the 3rd defines the type of the col.
	 * The value "seq-gen" is a name given to the "sequence" which is given in another annotation @GenericGenerator. 
	 * The "sequence" is a generator which hibernate has given for us.  
	 * */
	@GenericGenerator(name="seq-gen", strategy="sequence")
	@CollectionId(columns={@Column(name="Emp_Address_id")}, generator="seq-gen", type=@Type(type="int"))
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	
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
	
	public Collection<Address> getAddress() {
		return listOfAddress;
	}
	public void setAddress(Collection<Address> address) {
		this.listOfAddress = address;
	}

}

package com.hibernate.state;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student2")
public class Student {
	@Id
	Integer Id;
	String Name;
	Integer RollNumber;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getRollNumber() {
		return RollNumber;
	}
	public void setRollNumber(Integer rollNumber) {
		RollNumber = rollNumber;
	}
	
	
}

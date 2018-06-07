package com.hibernate.mapping.inheritance.TPS;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="REGULAR_TPS_EMPLOYEE")
@PrimaryKeyJoinColumn(name="id")    //A PK ‘id’ will be added to table Regular_Employee103 which is joined to the PK of master table TPS_EMPLOYEE
public class Regular_Employee extends Employee {
	private Float salary;
	private Float bonus;
	
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Float getBonus() {
		return bonus;
	}
	public void setBonus(Float bonus) {
		this.bonus = bonus;
	}
	
}

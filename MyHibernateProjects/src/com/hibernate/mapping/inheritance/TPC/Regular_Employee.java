package com.hibernate.mapping.inheritance.TPC;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="REGULAR_TPC_EMPLOYEE")
@AttributeOverrides({  //Specifies the array of @AttributeOverride                
	@AttributeOverride(name="id1", column=@Column(name="id")),       //Col id & name of the master table will be added to the derived table.
	@AttributeOverride(name="name1", column=@Column(name="name"))
})
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

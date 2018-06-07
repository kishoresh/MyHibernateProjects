package com.hibernate.mapping.inheritance.TPH;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("regular")  //Column type will have the value = regular
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

package com.hibernate.mapping.inheritance.TPC;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CONTRACT_TPC_EMPLOYEE")
@AttributeOverrides({      //Specifies the array of @AttributeOverride             
	@AttributeOverride(name="id2", column=@Column(name="id")),    //Col id & name of the master table will be added to the derived table.
	@AttributeOverride(name="name2", column=@Column(name="name"))
})
public class Contract_Employee extends Employee {
	private float pay_per_hour;
	private int contract_period;
	
	public float getPay_per_hour() {
		return pay_per_hour;
	}
	public void setPay_per_hour(float pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}
	public int getContract_period() {
		return contract_period;
	}
	public void setContract_period(int contract_period) {
		this.contract_period = contract_period;
	}
	
}

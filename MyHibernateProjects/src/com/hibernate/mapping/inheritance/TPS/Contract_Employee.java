package com.hibernate.mapping.inheritance.TPS;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CONTRACT_TPS_EMPLOYEE")
@PrimaryKeyJoinColumn(name="id")  //A PK ‘id’ will be added to table Contract_Employee103 which is joined to the PK of master table TPS_EMPLOYEE
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

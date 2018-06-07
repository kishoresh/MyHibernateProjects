package com.hibernate.mapping.association.manytoone;
/*
 * One to Many mapping of Employee and Address table.
 * 3 tables gets created - ADDRESS, EMPLOYEE_ADDR_OTM & EMPLOYEE_ADDR_OTM_ADDRESS
 * EMPLOYEE_ADDR_OTM_ADDRESS table stores the link and have 2 cols Employee_id & Address_id
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.setName("Kishore");
		
		Employee emp2 = new Employee();
		emp2.setName("Jyotirmoy");	
		
		Address addr1 = new Address();
		addr1.setId(1);
		addr1.setCity("Guwahati");
		addr1.setState("Assam");

//		Address addr2 = new Address();
//		addr2.setId(2);
//		addr2.setCity("Pune");
//		addr2.setState("Maharashtra");
		emp1.setAddr(addr1);
		emp2.setAddr(addr1);
		
//		emp.getAddress().add(addr1);
//		emp.getAddress().add(addr2);
	
		SessionFactory sfact = new Configuration().configure("hibernate.manytoonemapping.cfg.xml").buildSessionFactory();
		Session session = sfact.openSession();
		session.beginTransaction();
		session.save(addr1);
		//session.save(addr2);
		session.save(emp1);
		session.save(emp2);
		session.getTransaction().commit();
	}

}

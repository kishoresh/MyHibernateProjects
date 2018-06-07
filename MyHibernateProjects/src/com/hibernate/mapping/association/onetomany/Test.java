package com.hibernate.mapping.association.onetomany;
/*
 * One to Many mapping of Employee and Address table.
 * 3 tables gets created - ADDRESS, EMPLOYEE_OTM & EMPLOYEE_OTM_ADDRESS
 * EMPLOYEE_OTM_ADDRESS table stores the link and have 2 cols Employee_id & Address_id
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("Kishore");
		Employee emp2 = new Employee();
		emp2.setName("Sanjay");
		Employee emp3 = new Employee();
		emp3.setName("Balaji");
		
		Address addr1 = new Address();
		addr1.setId(1);
		addr1.setCity("Guwahati");
		addr1.setState("Assam");

		Address addr2 = new Address();
		addr2.setId(2);
		addr2.setCity("Pune");
		addr2.setState("Maharashtra");

		Address addr3 = new Address();
		addr3.setId(3);
		addr3.setCity("Hyderabad");
		addr3.setState("Telangana");
		
		emp.getAddress().add(addr1);
		emp.getAddress().add(addr2);
		
//		emp2.getAddress().add(addr1);
		emp2.getAddress().add(addr3);
//		emp3.getAddress().add(addr2);
//		emp3.getAddress().add(addr3);
		
		SessionFactory sfact = new Configuration().configure("hibernate.onetomanymapping.cfg.xml").buildSessionFactory();
		Session session = sfact.openSession();
		session.beginTransaction();
		session.save(addr1);
		session.save(addr2);
		session.save(addr3);
		
		session.save(emp);
		session.save(emp2);
		session.save(emp3);
		session.getTransaction().commit();
	}

}

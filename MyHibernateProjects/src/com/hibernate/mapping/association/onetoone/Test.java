package com.hibernate.mapping.association.onetoone;
/*
 * One to One mapping of Employee and Address table.
 * 2 tables are created EMPLOYEE_ADDR & Address.
 * EMPLOYEE_ADDR table have a col ADR_ID which will hold PK values of Address table.
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.mapping.association.onetoone.Address;
import com.hibernate.mapping.association.onetoone.Employee;

public class Test {

	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.setName("Kishore");
		Employee emp2 = new Employee();
		emp2.setName("Utkarsha");
		
		Address addr1 = new Address();
		addr1.setId(1);
		addr1.setCity("Guwahati");
		addr1.setState("Assam");
		emp1.setAdr(addr1);
		//emp.getAdr().add(addr1);

		Address addr2 = new Address();
		addr2.setId(2);
		addr2.setCity("Pune");
		addr2.setState("Maharashtra");
		emp2.setAdr(addr2);

		SessionFactory sfact = new Configuration().configure("hibernate.onetoonemapping.cfg.xml").buildSessionFactory();
		Session session = sfact.openSession();
		session.beginTransaction();
		session.save(addr1);
		session.save(addr2);
		session.save(emp1);
		session.save(emp2);
		session.getTransaction().commit();
	}

}

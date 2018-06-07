package com.hibernate.embedding.oneaddress;
/*
 * How the Address class is embedded to the Employee class using @Embeddable & @Embedded
 * @Embedded class   - Address
 * @Embeddable class - Employee
 * Result - One single table EMPLOYEE_ADDR_EMBEDDED having a record combined with Employee and Address details.
 */
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		e1.setName("Kishore");		
		e2.setName("Priyakshi");
		
		Address addr1 = new Address();
		Address addr2 = new Address();
		addr1.setCity("Pune");
		addr2.setCity("Guwahati");
		addr1.setState("Maharashtra");
		addr2.setState("Assam");
		
		e1.setAdr(addr1);
		e2.setAdr(addr2);
		
		SessionFactory sfact = new Configuration().configure("hibernate.embedding.oneaddress.cfg.xml").buildSessionFactory();
		Session session = sfact.openSession();
		session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.getTransaction().commit();	

	}

}

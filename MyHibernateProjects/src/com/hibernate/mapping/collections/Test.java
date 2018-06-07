package com.hibernate.mapping.collections;
/*
 * Note that here Address class is Embeddable and not an Entity. Address is stored as a collection of objects within Employee.
 * The output of collection objects is generated in a separate table Employee_listOfAddress. The name is not user freindly.
 * To rename the collection table we use @JoinTable() and to introduce a PK for the join tab we use @CollectionId() 
 * Result : 2 Tables created - EMPLOYEE_COLL (id, name) & Employee_Address (address_id, emp_id, city, state, country).
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
		
		Employee emp3 = new Employee();
		emp3.setName("Milli");
		
		Employee emp4 = new Employee();
		emp4.setName("Balaji");
		
		Address addr1 = new Address();
		addr1.setCity("Guwahati");
		addr1.setCountry("India");
		addr1.setState("Assam");

		Address addr2 = new Address();
		addr2.setCity("Pune");
		addr2.setCountry("India");
		addr2.setState("Maharashtra");
		
		Address addr3 = new Address();
		addr3.setCity("Hyderabad");
		addr3.setCountry("India");
		addr3.setState("Telangana");

		emp1.getAddress().add(addr1);
		emp1.getAddress().add(addr3);
		
		emp2.getAddress().add(addr2);
		emp3.getAddress().add(addr2);
		
		emp4.getAddress().add(addr1);
		emp4.getAddress().add(addr2);
		emp4.getAddress().add(addr3);
		
		SessionFactory sfact = new Configuration().configure("hibernate.collectionsmapping.cfg.xml").buildSessionFactory();
		Session session = sfact.openSession();
		session.beginTransaction();
//		session.save(addr1);     //We cannot do this, as Address is not an Entity and hence there is no DB table.
//		session.save(addr2);
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.getTransaction().commit();
	}

}

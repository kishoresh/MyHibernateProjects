package com.hibernate.second;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("Kishore");
		
		Address addr1 = new Address();
		addr1.setCity("Guwahati");
		addr1.setState("Assam");
		
		Address addr2 = new Address();
		addr2.setCity("Pune");
		addr2.setState("Maharastra");
		
		emp.setHome_address(addr1);
		emp.setOff_address(addr2);
		
		SessionFactory sfact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sfact.openSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sfact.openSession();
		session2.beginTransaction();
		
		TypedQuery<Employee> query = session2.createQuery("from Employee");
		java.util.List<Employee> datalist = query.getResultList();
		for(Employee data:datalist){
			System.out.println("ID : "+data.getId() + "\t" + " Name : " + data.getName() + "\t" +" Off City : " + data.getOff_address().getCity()
					+"\t Home City : " + data.getHome_address().getCity());
		}
		
		TypedQuery<Employee> q = session2.createQuery("update Employee set name=:nam where id=:i");
		q.setParameter("nam", "Jyotirmoy");
		q.setParameter("i", 1);
		int status = q.executeUpdate();
		System.out.println("Status : " + q);
		
		session2.getTransaction().commit();
		session2.close();	
	}

}

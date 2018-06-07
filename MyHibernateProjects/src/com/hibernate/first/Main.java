package com.hibernate.first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {		
		Info info = new Info();
		//info.setId(1);
		info.setName("Kishore");
		
		Address addr = new Address();
		Address addr2 = new Address();
		addr.setCity("Pune");
		addr2.setCity("Guwahati");
		addr.setState("Maharashtra");
		addr2.setState("Assam");
		
		info.getListofAddress().add(addr);
		info.getListofAddress().add(addr2);
		
		SessionFactory sfact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sfact.openSession();
		session.beginTransaction();
		session.saveOrUpdate(info);
		session.getTransaction().commit();
		
	}

}

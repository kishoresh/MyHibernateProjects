package com.hibernate.mapping.inheritance.TPS;
/*
 * Inheritance Mapping - Table Per Subclass using annotations.
 * 3 Class : Parent Class - Employee have 2 subclasses - Regular Employee & Contract Employee
 * This mapping, will create 3 tables master table employee103 and 2 subclass tables - Regular_Employee103 & Contract_Employee103 
 * PK id is added in both subclass table Regular_Employee103 & Contract_Employee103 and is joined to emp_id of the master table employee103.
 * 
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setName("Kishore Sharma");
		
		Regular_Employee e2 = new Regular_Employee();
		e2.setName("Jyotirmoy Sharma");
		e2.setSalary(20000.00F);
		e2.setBonus(10000F);
				
		Regular_Employee e3 = new Regular_Employee();
		e3.setName("Priyakshi Sharma");
		e3.setSalary(70000F);
		e3.setBonus(20000F);
			
		Contract_Employee e4 = new Contract_Employee();
		e4.setName("Utkarsha Sharma");
		e4.setPay_per_hour(1000F);
		e4.setContract_period(12);
		
		Contract_Employee e5 = new Contract_Employee();
		e5.setName("Milli Sharma");
		e5.setContract_period(24);
		e5.setPay_per_hour(800);
		
		Session session = null;
		Transaction tx = null;
		
		try{
		SessionFactory sesFactory = new Configuration().configure("hibernate.inheritancemapping.TPS.cfg.xml").buildSessionFactory();
		session = sesFactory.openSession();
		tx = session.beginTransaction();
		
		session.save(e1);
		
		session.save(e2);
		session.save(e3);
		
		session.save(e4);
		session.save(e5);
		
		tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}

	}

}

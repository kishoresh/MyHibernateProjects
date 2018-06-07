package com.hibernate.mapping.inheritance.TPC;
/*
 * Inheritance Mapping - Table Per Concrete class.
 * 3 Class : Parent Class - Employee have 2 subclasses - Regular Employee & Contract Employee
 * This mapping, will create a 3 tables employee102, Contract_Employee102 & Regular_Employee102. 
 * Col id & name of the master table employee102 will be added to the subclass tables. 
 * So the col id & name exist in all the tables and hence there is no join between the tables.
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
		SessionFactory sesFactory = new Configuration().configure("hibernate.inheritancemapping.TPC.cfg.xml").buildSessionFactory();
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

package com.hibernate.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestObjectState {

	public static void main(String[] args) {
	        Configuration configuration = new Configuration();
	        configuration.configure("hibernate.objectstate.cfg.xml");
	        SessionFactory factory = configuration.buildSessionFactory();
	        Session session = factory.openSession();
	// Transient State
	        Student student = new Student();
	        student.setId(111);
	        student.setName("Chandrashekhar");
	        student.setRollNumber(10);
	        Transaction transaction = session.beginTransaction();
	// Going to Persistent State
	        session.save(student);
	        student.setName("Kishore Sharma"); // Updated in database
	        transaction.commit();
	        session.close();
	// Detatched state
	        Session session2 = factory.openSession();
	        Transaction transaction2 = session2.beginTransaction();
	        session2.update(student);     // reattaching
	        student.setRollNumber(40);    // Updated in Database
	        session2.evict(student);      // Detaching student object from session
	        student.setId(300);           // not update to Database.
	        
	        Student student2 = session2.get(Student.class, 111);    //Use get() to retrieve the Student details.
	        student2.setRollNumber(500);  // Updated in Database
	        session2.update(student2);
	        transaction2.commit();
	        
//	        Object o = session2.get(Student.class, 101);
//	        Student st = (Student) o;
//	        System.out.println("Student name : "+ st.getName());
	        session2.close();
	        
	        
	    }
	}



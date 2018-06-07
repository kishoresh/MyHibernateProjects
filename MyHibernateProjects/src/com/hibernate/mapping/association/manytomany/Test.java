package com.hibernate.mapping.association.manytomany;
/*
 * Many to Many relationship between Student & Course.
 * A student can enroll in any number of courses and a course can be enrolled by any number of students.
 * 4 tables gets created :-student, Course, course_student & student_course.
 * student_course & course_student - holds the studentid & courseid
 */
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Course c1 = new Course();
		Course c2 = new Course();
		c1.setCourseName("Hibernate3");
		c1.setCoursedays(10);
		c2.setCourseName("Java");
		c2.setCoursedays(20);
		
		Student s1 = new Student();
		Student s2 = new Student();
		s1.setStudentName("Kishore Sharma");
		s2.setStudentName("Jyotirmoy Sharma");

		s1.getCourse().add(c1);
		s2.getCourse().add(c2);
		c1.getStudent().add(s1);
		c2.getStudent().add(s2);

		Transaction tx = null;
		Session session = null;
		try{
			SessionFactory sesFactory = new Configuration().configure("hibernate.manytomanymapping.cfg.xml").buildSessionFactory();
			session = sesFactory.openSession();
			tx = session.beginTransaction();
			
			session.save(s1);
			session.save(s2);
			session.save(c1);
			session.save(c2);
			tx.commit();
		}catch (HibernateException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}

}

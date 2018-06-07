package com.hibernate.HQL;

/*
 * Note that here Address class is Embeddable and not an Entity. Address is stored as a collection of objects within Employee.
 * The output of collection objects is generated in a separate table Employee_listOfAddress. The name is not user freindly.
 * To rename the collection table we use @JoinTable() and to introduce a PK for the join tab we use @CollectionId() 
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.mapping.collections.Address;
import com.hibernate.mapping.collections.Employee;

public class Test {
	
	public static void displayEmployees(List<Employee> list){
		for(Employee data:list){
			System.out.println(
					"ID : " + data.getId() + " "+ 
					"Name : " + data.getName());
			Iterator<Address> itr = data.getAddress().iterator();
			while (itr.hasNext()){
				Address adr = itr.next();
				System.out.println("City : " + adr.getCity() + " " +
						"State : " + adr.getState());				
			}
		}
	
	}
	
	//Get all the records of Employee and the Addresses.
	public static void getAllRecordsAndDisplay(SessionFactory sfact){		
		Session ses = sfact.openSession();
		ses.beginTransaction();
		Query query = ses.createQuery("from Employee");
		List<Employee> list = query.getResultList();
		displayEmployees(list);
		ses.close();		
	}
	
	//Get records with Pagination
	public static void getRecordsWithPagination(SessionFactory sfact){
		Session ses = sfact.openSession();
		ses.beginTransaction();
		Query query = ses.createQuery("from Employee");
		query.setFirstResult(3);
		query.setMaxResults(4);
		List<Employee> list = query.getResultList();
		displayEmployees(list);
		ses.close();			
	}
	
	//Get records with Select statement
	//Error : This does not work, as Employee class have a Collection object Address, and it is not in the select list.
	public static void getRecordsWithSelect(SessionFactory sfact){
		Session ses = sfact.openSession();
		ses.beginTransaction();
		Query query = ses.createQuery("select id, name from Employee");
		List<Employee> list = query.getResultList();
		for(Employee data:list){
			System.out.println(
					"ID : " + data.getId() + " "+ 
					"Name : " + data.getName());
		}
		ses.close();			
	}
	
	public static void getEmployee(SessionFactory sfact){
		Session ses = sfact.openSession();
		ses.beginTransaction();
		Employee emp = ses.get(Employee.class, 5);
		System.out.println("ID : " + emp.getId() + " Name : " + emp.getName());
		ses.close();			
	}
	
	//Delete an employee without using query.
	public static void deleteEmployee(SessionFactory sfact){
		Session ses = sfact.openSession();
		ses.beginTransaction();
		Employee emp = ses.get(Employee.class, 5);
		ses.delete(emp);
		ses.getTransaction().commit();
		ses.close();			
	}
	
	//Update an employee without using query.
	public static void updateEmployee(SessionFactory sfact){
		Session ses = sfact.openSession();
		ses.beginTransaction();
		Employee emp = ses.get(Employee.class, 5);
		emp.setName("Üpdated name");		
		ses.update(emp);
		ses.getTransaction().commit();
		ses.close();			
	}
	
	//Delete an Employee record with a query 
	public static void deleteEmployeeWithQuery(SessionFactory sfact){
		Session ses = sfact.openSession();
		ses.beginTransaction();
		Query query = ses.createQuery("delete from Employee where id=5");
		query.executeUpdate();
		ses.close();			
	}
	
	//Update an Employee record with a query 
	public static void updateEmployeeWithQuery(SessionFactory sfact){
		Session ses = sfact.openSession();
		ses.beginTransaction();
		Query q = ses.createQuery("update Employee set name =:n where id=:i");
		q.setParameter("n", "Updated Employee name");
		q.setParameter("i", 6);
		int status = q.executeUpdate();
		System.out.println(status);
		ses.close();			
	}

	//Calling a Stored Procedure - Get an Employee record by SP 
	public static void callStoredProcedure(SessionFactory sfact){
		Session ses = sfact.openSession();
		ses.beginTransaction();
		//Query q = ses.createSQLQuery("CALL GetEmployee(:empID)").addEntity(Employee.class);
		//q.setParameter("empID", 5);
		SQLQuery<Employee> q = ses.createSQLQuery("CALL GetEmployee(:empID)")
				.addEntity(Employee.class)
				.setParameter("empID", 5);

		List<Employee> result = q.getResultList();
		for(int i=0; i < result.size(); i++){
			System.out.println(result.get(i).getName());
		}
		//System.out.println(status);
		ses.close();			
	}

	public static void main(String[] args) {
		Address addr1 = new Address();
		addr1.setCity("Guwahati");
		addr1.setState("Assam");

		Address addr2 = new Address();
		addr2.setCity("Pune");
		addr2.setState("Maharashtra");

		SessionFactory sfact = new Configuration().configure("hibernate.collectionsmapping.cfg.xml").buildSessionFactory();
		Session session = sfact.openSession();
		session.beginTransaction();
		for(int i=0; i <10; i++){
			Employee emp = new Employee();
			emp.setName("Employee-"+i);
			emp.getAddress().add(addr1);
			emp.getAddress().add(addr2);
			session.save(emp);
		}
		session.getTransaction().commit();
		session.close();
		
		getAllRecordsAndDisplay(sfact);
		//getRecordsWithPagination(sfact);
		//getEmployee(sfact);
		//getRecordsWithSelect(sfact);   //Error
		//deleteEmployeeWithQuery(sfact);
		//updateEmployeeWithQuery(sfact);
		//deleteEmployee(sfact);
		//updateEmployee(sfact);
		//callStoredProcedure(sfact);
	}

}

package com.hibernate.mapping.association.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id @GeneratedValue
	private int courseid;
	private String courseName;
	private int coursedays;
	
	@ManyToMany
	private Collection<Student> student = new ArrayList<>();
	
	public int getCourseid() {
		return courseid;
	}

	public String getCourseName() {
		return courseName;
	}

	public Collection<Student> getStudent() {
		return student;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setStudent(Collection<Student> student) {
		this.student = student;
	}

	public int getCoursedays() {
		return coursedays;
	}

	public void setCoursedays(int coursedays) {
		this.coursedays = coursedays;
	}


	

}

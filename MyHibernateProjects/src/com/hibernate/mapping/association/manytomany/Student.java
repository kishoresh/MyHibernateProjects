package com.hibernate.mapping.association.manytomany;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id  @GeneratedValue
	private int studetid;
	private String studentName;
	
	@ManyToMany
	private Collection<Course> course = new ArrayList<>();
	
	public int getStudetid() {
		return studetid;
	}

	public void setStudetid(int studetid) {
		this.studetid = studetid;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Collection<Course> getCourse() {
		return course;
	}

	public void setCourse(Collection<Course> course) {
		this.course = course;
	}
	

}

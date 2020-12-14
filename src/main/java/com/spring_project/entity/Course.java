package com.spring_project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "course")
public class Course {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "courseName")
	private String name;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonBackReference(value = "student_course")
	@ManyToMany(mappedBy = "courses",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	List <Student> students;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonBackReference(value = "teacher_course")
	@ManyToMany(mappedBy = "courses",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	List <Teacher> teachers;
	
	public Course() {}
	
	public Course(String name) {
	
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + 
				", students=" + students + ", teachers=" + teachers + 
				"]";
	}
	
}

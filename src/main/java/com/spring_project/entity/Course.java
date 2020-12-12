package com.spring_project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "course")
public class Course {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "courseName")
	private String name;

	@JsonBackReference(value = "student_course")
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "student_course" ,joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	List <Student> students;
	
	@JsonBackReference(value = "teacher_course")
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "teacher_course" ,joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	List <Teacher> teachers;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)	
	@JoinColumn(name ="courseId")
	List<Question> question;
	
	@OneToMany(targetEntity = Test.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)	
	@JoinColumn(name ="courseId")
	List<Test> test;
	
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
		return "Course [id=" + id + ", name=" + name + ", students=" + students + ", teachers=" + teachers + "]";
	}

	
	
}

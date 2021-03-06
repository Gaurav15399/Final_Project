package com.spring_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TEST_RESULT")
public class TestResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private int marks;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(targetEntity = Test.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "TEST_ID", nullable = false)
	private Test test;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(targetEntity = Student.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "STUDENT_ID",nullable = false)
	private Student student;
	
	public TestResult() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}

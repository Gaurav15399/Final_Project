package com.spring_project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Test {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	@Column
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Course course;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = TestResult.class)
	@JoinColumn(name = "TEST_ID")
	TestResult testResult;
}

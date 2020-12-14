package com.spring_project.entity;

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
@Table(name = "TEST_QUESTION")
public class TestQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Test.class)
	@JoinColumn(name = "TEST_ID")
	private Test test;
	
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Question.class)
	@JoinColumn(name = "QUESTION_ID")
	private Question questions;

	public TestQuestion() {
		super();
	}

	public TestQuestion(Test test,Question question) {
		super();
		this.test = test;
		this.questions = question;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Question getQuestions() {
		return questions;
	}

	public void setQuestions(Question questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "TestQuestion [id=" + id + ", questions=" + questions + "]";
	}

}

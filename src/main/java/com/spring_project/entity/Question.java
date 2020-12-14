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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "question")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String questionValue;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Course.class)
	@JoinColumn(name ="courseId")
	private Course course;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name ="qid")
	private List<Option> options;


	public Question() {

	}

	public Question(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(String questionValue,int courseId) {
		this.questionValue = questionValue;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Question(String questionValue, List<Option> options) {
		super();
		this.questionValue = questionValue;
		this.options = options;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionValue=" + questionValue + ", options=" + options + "]";
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}


}
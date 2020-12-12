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
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "question")
public class Question {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String questionValue;
	@Column
	private int courseId;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name ="qid")
	private List<Option> options;
	
	
	public Question() {
		
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
		this.courseId=courseId;
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

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
}
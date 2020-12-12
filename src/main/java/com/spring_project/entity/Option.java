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
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class Option {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	
	@Column
	private String optionValue;
	
	@Column
	private int answer;

	
	
	
	public Option() {}
	public Option(String optionValue, int answer) {
		
		this.optionValue = optionValue;
		this.answer = answer;
		//this.qid = qid;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOptionValue() {
		return optionValue;
	}
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer=answer;
	}
	


	
	
	

}

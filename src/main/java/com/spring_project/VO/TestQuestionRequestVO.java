package com.spring_project.VO;

import java.util.List;

import com.spring_project.entity.Question;
import com.spring_project.entity.Test;

public class TestQuestionRequestVO {

	private Test test;
	
	private List<Question> questions;
	
	public TestQuestionRequestVO() {
		super();
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
}

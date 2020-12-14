package com.spring_project.dao;

import java.util.List;

import com.spring_project.entity.Question;

public interface QuestionDao {

	public void addQuestion(Question theQuestion);

	public List<Question> getQuestions();

	public void deleteQuestion(int questionId);
	
	public List<Question> getCourseQuestions(int courseId);
	
}

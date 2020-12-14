package com.spring_project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_project.dao.QuestionDao;
import com.spring_project.entity.Question;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDao questionDao;
	@Override
	@Transactional
	public void addQuestion(Question theQuestion) {
		// TODO Auto-generated method stub
		questionDao.addQuestion(theQuestion);
	}

	
	@Override
	public List<Question> getQuestions() {
		return questionDao.getQuestions();
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteQuestion(int questionId) {
		// TODO Auto-generated method stub
		questionDao.deleteQuestion( questionId);
	}

	@Override
	@Transactional
	public List<Question> getCourseQuestions(int courseId) {
		// TODO Auto-generated method stub
		return questionDao.getCourseQuestions(courseId);
	}
	
	

}

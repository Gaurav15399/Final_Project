package com.spring_project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.entity.Question;

@Repository
public class QuestrionDaoImpl implements QuestionDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public void addQuestion(Question theQuestion)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(theQuestion);
		//optionList=theQuestion.getOptions();
		//theQuestion.getId();
		//System.out.println(optionList);
		
	}

	@Override
	public List<Question> getQuestions() {
		
		List<Question>questions;
		questions = entityManager.createQuery("FROM Question", Question.class).getResultList();
		return questions;
	}

	@Override
	public void deleteQuestion(int questionId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Question theQuestion = session.get(Question.class, questionId);
		session.delete(theQuestion);
		
	}
	
	@Override
	public List<Question> getCourseQuestions(int courseId) {
		
		List<Question> questions=entityManager.createQuery(
				"from Question where courseId=:cid",Question.class
				).setParameter("cid", courseId).getResultList();
				
		return questions;
	}
}

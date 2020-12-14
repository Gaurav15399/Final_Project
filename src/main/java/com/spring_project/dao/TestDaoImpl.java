package com.spring_project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import com.spring_project.entity.Test;
import com.spring_project.entity.TestQuestion;
import com.spring_project.entity.TestResult;

@Repository
public class TestDaoImpl implements TestDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public Test saveTest(Test test) {
		entityManager.getTransaction().begin();
		entityManager.persist(test);
		entityManager.getTransaction().commit();
		return test;
	}

	@Override
	public Test getTest(int testId) {
		Test test = entityManager.find(Test.class, testId);
		return test;
	}


	@Override
	public TestResult saveTestResult(TestResult testResult) {
		entityManager.getTransaction().begin();
		System.out.println(entityManager.isJoinedToTransaction());
		entityManager.persist(testResult);
		entityManager.getTransaction().commit();
		System.out.println(entityManager.getTransaction().isActive());
		return testResult;
	}



	@Override
	public TestResult getTestReultByStudentIdAndTestId(int studentId, int testId) {

		final String getTestRequestQuery = "FROM TestResult tr WHERE tr.student.id = :studentId AND tr.test.id = :testId";

		return entityManager.createQuery(getTestRequestQuery, TestResult.class)
				.setParameter("studentId", studentId)
				.setParameter("testId", testId)
				.getSingleResult();
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED)
	public TestQuestion saveTestQuestion(TestQuestion testQuestion) {
		entityManager.getTransaction().begin();
		entityManager.persist(testQuestion);
		entityManager.getTransaction().commit();
		return testQuestion;
	}

	@Override
	public List<TestQuestion> getTestQuestionList(int testId) {

		final String getTestQuestionRequestQuery = "FROM TestQuestion tq WHERE tq.test.id = :testId";

		return entityManager.createQuery(getTestQuestionRequestQuery, TestQuestion.class)
				.setParameter("testId", testId)
				.getResultList();
	}
}


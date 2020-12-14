package com.spring_project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_project.VO.SubmitTestVO;
import com.spring_project.VO.TestQuestionRequestVO;
import com.spring_project.dao.TestDao;
import com.spring_project.entity.Question;
import com.spring_project.entity.Student;
import com.spring_project.entity.Test;
import com.spring_project.entity.TestQuestion;
import com.spring_project.entity.TestResult;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	TestDao testDao;
	
	@Override
	@Transactional
	public TestResult saveTestResult(SubmitTestVO submitTestVO) {
		
		//TestResult
		TestResult testResult = new TestResult();
		//getQuestionsByCourse
		List<Question> fetchedQuestions = questionService.getCourseQuestions(submitTestVO.getTest().getCourse().getId());
		
		System.out.println(fetchedQuestions);
		System.out.println("***************");
		//check with fetched Questions and submitted questions 
		submitTestVO.getQuestionDetailList().stream().forEach(submitq->{
			fetchedQuestions.stream().forEach(q->{
				if(q.getId() == submitq.getQuestionId()) {
					q.getOptions().stream().forEach(o->{
						//calculate marks
						if(o.getAnswer() == 1 && o.getId() == submitq.getOptionId()) {
							System.out.println(o.getId());
							testResult.setMarks(testResult.getMarks()+10);
						}
					});
				}
			});
		});
		
		// prepare entity 
		
		testResult.setStudent(new Student(submitTestVO.getSid()));
		testResult.setTest(submitTestVO.getTest());
		//save
		return testDao.saveTestResult(testResult);
	}

	@Override
	public Test getTest(int id) {
		
		return testDao.getTest(id);
	}

	@Override
	public TestResult getTestResult(int studentId,int testId) {
	
		return testDao.getTestReultByStudentIdAndTestId(studentId, testId);
	}

	@Override
	public Test saveTest(Test test) {

		return testDao.saveTest(test);
	}

	@Override
	@Transactional
	public Test generateTest(TestQuestionRequestVO testQuestionRequestVO) {
		
		testDao.saveTest(testQuestionRequestVO.getTest());
		List<TestQuestion> testQuestionList = new ArrayList<>();
		testQuestionRequestVO.getQuestions().stream().forEach(q->testQuestionList.add(new TestQuestion(testQuestionRequestVO.getTest(),q)));
		testQuestionList.stream().forEach(tq->testDao.saveTestQuestion(tq));
		return testQuestionRequestVO.getTest();
	}

	@Override
	public List<Question> getQuestionsForTest(int testId) {
		List<TestQuestion> testQuestionList = testDao.getTestQuestionList(testId);
//		System.out.println(testQuestionList);
		List<Question> l = testQuestionList.stream().map(tq->tq.getQuestions()).collect(Collectors.toList());
		System.out.println(l);
		return l;
		
	}
	
}

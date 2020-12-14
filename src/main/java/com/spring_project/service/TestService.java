package com.spring_project.service;

import java.util.List;

import com.spring_project.VO.SubmitTestVO;
import com.spring_project.VO.TestQuestionRequestVO;
import com.spring_project.entity.Question;
import com.spring_project.entity.Test;
import com.spring_project.entity.TestResult;

public interface TestService {

	public TestResult saveTestResult(SubmitTestVO submitTestVO);

	public Test getTest(int id);

	public TestResult getTestResult(int id, int teacherId);

	public Test saveTest(Test test);

	public Test generateTest(TestQuestionRequestVO testQuestionRequestVO);

	public List<Question> getQuestionsForTest(int testId);
	
}

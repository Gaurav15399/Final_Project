package com.spring_project.dao;

import java.util.List;

import com.spring_project.entity.Test;
import com.spring_project.entity.TestQuestion;
import com.spring_project.entity.TestResult;

public interface TestDao {

	public Test saveTest(Test test);
	
	public Test getTest(int testId);
	
	public TestResult saveTestResult(TestResult testResult);
	
	public TestResult getTestReultByStudentIdAndTestId(int studentId, int testId);

	public TestQuestion saveTestQuestion(TestQuestion testQuestion);

	List<TestQuestion> getTestQuestionList(int testId);
}

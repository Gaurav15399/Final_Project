package com.spring_project.VO;

import java.util.List;

import com.spring_project.entity.Test;

public class SubmitTestVO {

	int sid;

	Test test;

	List<QuestionDetailVO> questionDetailList;

	public SubmitTestVO() {
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}

	public List<QuestionDetailVO> getQuestionDetailList() {
		return questionDetailList;
	}
	public void setQuestionDeatilList(List<QuestionDetailVO> questionDetailList) {
		this.questionDetailList = questionDetailList;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
}
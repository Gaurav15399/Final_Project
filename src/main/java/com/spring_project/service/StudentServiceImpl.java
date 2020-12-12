package com.spring_project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_project.dao.StudentDao;
import com.spring_project.entity.Course;
import com.spring_project.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;
	
	@Override
	@Transactional
	
	public void saveStudent(Student theStudent) {
		// TODO Auto-generated method stub
		studentDao.saveStudent(theStudent);
	}

	@Override
	@Transactional
	public List<Student> getStudents() {	
		return studentDao.getStudents();
	}

	@Override
	@Transactional
	public void deleteStudent(int studentId) {
		studentDao.deleteStudent(studentId);
		
	}

	@Override
	@Transactional
	public void addStudentCourse(int studentId, int courseId) {
		// TODO Auto-generated method stub
		studentDao.addStudentCourse(studentId,courseId);
	}

	@Override
	@Transactional
	public void deleteStudentCourse(int studentId, int courseId) {
		// TODO Auto-generated method stub
		studentDao.deleteStudentCourse(studentId,courseId);
	}


}

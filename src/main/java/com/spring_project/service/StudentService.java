package com.spring_project.service;

import java.util.List;

import com.spring_project.entity.Student;

public interface StudentService {

	public void saveStudent(Student theStudent);

	public List<Student> getStudents();

	public void deleteStudent(int studentId);

	public void deleteStudentCourse(int studentId, int courseId);

	
}

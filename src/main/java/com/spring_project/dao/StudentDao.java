package com.spring_project.dao;

import java.util.List;

import com.spring_project.entity.Course;
import com.spring_project.entity.Student;

public interface StudentDao {

	public void saveStudent(Student theStudent);

	

	public List<Student> getStudents();



	public void deleteStudent(int studentId);



	public void addStudentCourse(int studentId, int courseId);



	public void deleteStudentCourse(int studentId, int courseId);



}

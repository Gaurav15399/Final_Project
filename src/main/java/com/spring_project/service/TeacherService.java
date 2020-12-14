package com.spring_project.service;

import java.util.List;

import com.spring_project.entity.Student;
import com.spring_project.entity.Teacher;

public interface TeacherService {
	
	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher theTeacher);

	public void deleteTeacher(int teacherId);

	public void addTeacherCourse(int teacherId, int courseId);

	public void deleteTeacherCourse(int teacherId, int courseId);

	public void deleteStudentCourse(int studentId, int courseId);

	public List<Student> getCourseStudents(int teacherId, int courseId);
}

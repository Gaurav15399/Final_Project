package com.spring_project.dao;

import java.util.List;

import com.spring_project.entity.Course;
import com.spring_project.entity.Option;
import com.spring_project.entity.Question;
import com.spring_project.entity.Student;
import com.spring_project.entity.Teacher;

public interface TeacherDao {
	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher theTeacher);

	public void deleteTeacher(int teacherId);

	public void addTeacherCourse(int teacherId, int courseId);

	public void deleteTeacherCourse(int teacherId, int courseId);

	public List<Student> getCourseStudents(int teacherId, int courseId);

	public void addQuestion(Question theQuestion);

	public List<Question> getQuestions();

	public void deleteQuestion(int questionId);

	public List<Question> getCourseQuestions(int courseId);
}

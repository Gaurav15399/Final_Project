package com.spring_project.dao;

import java.util.List;

import com.spring_project.entity.Course;

public interface CourseDao {

	public void addCourse(Course theCourse) ;
	public void deleteCourse(int courseId);
	public List<Course> showCourses();
}

package com.spring_project.service;

import java.util.List;

import com.spring_project.entity.Course;

public interface CourseService {

		public void addCourse(Course theCourse) ;
		public void deleteCourse(int courseId);
		public List<Course> showCourses();
}

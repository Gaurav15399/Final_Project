package com.spring_project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_project.dao.CourseDao;
import com.spring_project.entity.Course;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;
	
	@Override
	@Transactional
	public void addCourse(Course theCourse) {
		// TODO Auto-generated method stub
		courseDao.addCourse(theCourse);
	}

	@Override
	@Transactional
	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		courseDao.deleteCourse(courseId);
	}

	@Override
	@Transactional
	public List<Course> showCourses() {
		// TODO Auto-generated method stub
		return courseDao.showCourses();

	}

}

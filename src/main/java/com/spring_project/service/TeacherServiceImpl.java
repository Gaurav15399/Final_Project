package com.spring_project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_project.dao.TeacherDao;
import com.spring_project.entity.Student;
import com.spring_project.entity.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;
	
	@Transactional
	@Override
	public List<Teacher> getTeachers() {
		
		return teacherDao.getTeachers();
	}
	
	@Transactional
	@Override
	public void saveTeacher(Teacher theTeacher) {

	 teacherDao.saveTeacher(theTeacher);
		
	}

	@Override
	@Transactional
	public void deleteTeacher(int teacherId) {
		teacherDao.deleteTeacher(teacherId);
		
	}

	@Override
	@Transactional
	public void addTeacherCourse(int teacherId, int courseId) {
		// TODO Auto-generated method stub
		teacherDao.addTeacherCourse(teacherId,courseId);
		
	}

	@Override
	@Transactional
	public void deleteTeacherCourse(int teacherId, int courseId) {
		teacherDao.deleteTeacherCourse(teacherId,courseId);
		
	}

	@Override
	public void deleteStudentCourse(int studentId, int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Student> getCourseStudents(int teacherId, int courseId) {
		// TODO Auto-generated method stub
		return teacherDao.getCourseStudents(teacherId,courseId);
	}

}

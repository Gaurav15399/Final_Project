package com.spring_project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.entity.Course;
import com.spring_project.entity.Student;
import com.spring_project.entity.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Teacher> getTeachers() {
		List<Teacher>teachers;
		Session session =sessionFactory.getCurrentSession();
		teachers=session.createQuery("from Teacher",Teacher.class).getResultList();
		return teachers;
		
		
		
	}
	
	@Override
	public void saveTeacher(Teacher theTeacher) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(theTeacher);
	}

	@Override
	public void deleteTeacher(int teacherId) {
		Session session=sessionFactory.getCurrentSession();
		Teacher theTeacher=session.get(Teacher.class, teacherId);
		session.delete(theTeacher);
		
	}

	

	@Override
	public void deleteTeacherCourse(int teacherId, int courseId) {

		Session session=sessionFactory.getCurrentSession();
		Course mycourse=session.get(Course.class, courseId);
		Teacher theTeacher=session.get(Teacher.class, teacherId);
		theTeacher.getCourses().remove(mycourse);
	}

	@Override
	public List<Student> getCourseStudents(int teacherId, int courseId) {
		Teacher theTeacher=entityManager.find(Teacher.class, teacherId);
		Course mycourse=entityManager.find(Course.class, courseId);
		return 	mycourse.getStudents();

	}
}

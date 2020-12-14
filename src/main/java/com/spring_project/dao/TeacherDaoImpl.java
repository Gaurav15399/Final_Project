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
	public void addTeacherCourse(int teacherId, int courseId) {
		
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Course mycourse=session.get(Course.class, courseId);
		Teacher theTeacher=session.get(Teacher.class, teacherId);
//		theTeacher.setCourses(mycourse);
		System.out.println(theTeacher.getCourses());
	}

	@Override
	public void deleteTeacherCourse(int teacherId, int courseId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Course mycourse=session.get(Course.class, courseId);
		Teacher theTeacher=session.get(Teacher.class, teacherId);
		theTeacher.deleteCourse(mycourse);
		System.out.println(theTeacher.getCourses());
	}

	@Override
	public List<Student> getCourseStudents(int teacherId, int courseId) {
		Teacher theTeacher=entityManager.find(Teacher.class, teacherId);
		List<Student> students = theTeacher.getCourses().stream().filter(c->c.getId() == courseId).map(c->c.getStudents()).findFirst().get();		
		return students;

	}
}

package com.spring_project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.entity.Course;
import com.spring_project.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public void saveStudent(Student theStudent) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(theStudent);
	}

	@Override
	public List<Student> getStudents() {
		Session session=sessionFactory.getCurrentSession();
		List<Student>students;
		students=session.createQuery("from Student",Student.class).getResultList();
		return students;
	}

	@Override
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Student theStudent=session.get(Student.class,studentId);
		session.delete(theStudent);
		
	
	}

	@Override
	public void deleteStudentCourse(int studentId, int courseId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Course mycourse=session.get(Course.class, courseId);
		Student theStudent=session.get(Student.class, studentId);
		theStudent.deleteCourse(mycourse);
		System.out.println(theStudent.getCourses());
	}

	
}

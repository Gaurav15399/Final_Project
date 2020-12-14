package com.spring_project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.entity.Course;

@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public void addCourse(Course theCourse) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCourse);

	}

	@Override
	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Course theCourse=session.get(Course.class, courseId);
		session.delete(theCourse);
		

	}

	@Override
	public List<Course> showCourses() {
		// TODO Auto-generated method stub
		
		List<Course>courses=entityManager.createQuery("from Course",Course.class).getResultList();
		return courses;
		}

	

}

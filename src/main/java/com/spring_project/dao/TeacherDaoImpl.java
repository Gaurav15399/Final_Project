package com.spring_project.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.entity.Course;
import com.spring_project.entity.Option;
import com.spring_project.entity.Question;
import com.spring_project.entity.Student;
import com.spring_project.entity.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	SessionFactory sessionFactory;
	
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
		System.out.println(theTeacher.getId());
		
		
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
		theTeacher.setCourses(mycourse);
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
		Session session = sessionFactory.getCurrentSession();
		Teacher theTeacher=session.get(Teacher.class, teacherId);
		Course c  = null;
		for( Course course : theTeacher.getCourses()) {
			if(course.getId() == courseId) {
				c = course;
			}
		}
		session.update(c);
		return c.getStudents();
//		Hibernate.initialize(c.getStudents());
		
//		System.out.println("theTeacher*\t"+theTeacher);
//		Course theCourse=session.get(Course.class, courseId);
//		System.out.println("theCourse*\t"+theCourse);
//		List<Student> theStudent;
//		
//		theStudent=theCourse.getStudents();
//		return theStudent;
	}

	@Override
	public void addQuestion(Question theQuestion)
	{
		Session session=sessionFactory.getCurrentSession();
		List<Option>optionList;
		session.saveOrUpdate(theQuestion);
		//optionList=theQuestion.getOptions();
		//theQuestion.getId();
		//System.out.println(optionList);
		
	}

	@Override
	public List<Question> getQuestions() {
		
		List<Question>questions;
		Session session =sessionFactory.getCurrentSession();
		questions=session.createQuery("from Question",Question.class).getResultList();
		
		return questions;
	}

	@Override
	public void deleteQuestion(int questionId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Question theQuestion = session.get(Question.class, questionId);
		session.delete(theQuestion);
		
	}

	@Override
	public List<Question> getCourseQuestions(int courseId) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		List<Question> questions=session.createQuery(
				"from Question where courseId=:cid",Question.class
				).setParameter("cid", courseId).getResultList();
				
		return questions;
	}

}

package com.spring_project.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_project.VO.SubmitTestVO;
import com.spring_project.VO.TestQuestionRequestVO;
import com.spring_project.entity.Course;
import com.spring_project.entity.Question;
import com.spring_project.entity.Student;
import com.spring_project.entity.Teacher;
import com.spring_project.entity.Test;
import com.spring_project.entity.TestResult;
import com.spring_project.service.CourseService;
import com.spring_project.service.QuestionService;
import com.spring_project.service.StudentService;
import com.spring_project.service.TeacherService;
import com.spring_project.service.TestService;

import io.swagger.annotations.Api;


@RequestMapping("/api")
@RestController
@Api(tags = "Controller for student test application")
public class TheRestController {
	@Autowired
	StudentService studentService;

	@Autowired
	TeacherService teacherService;
	
	@Autowired
	QuestionService questionService;

	@Autowired
	CourseService courseService;

	@Autowired
	TestService testService;

	// Student Section 	
	@PostMapping("/students")
	public Student saveOrUpdate(@RequestBody Student theStudent)
	{
		studentService.saveStudent(theStudent);
		return theStudent;
	}


	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return studentService.getStudents();
	}

	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId)
	{
		studentService.deleteStudent(studentId);
		return "deleted Sucessfully";
	}

	@DeleteMapping("/students/{studentId}/{courseId}")
	public String deleteStudentCourse(@PathVariable int studentId, @PathVariable int courseId)
	{
		studentService.deleteStudentCourse(studentId,courseId);
		return "deleted";
	}

	//TEACHER
	@GetMapping("/teachers")
	public List<Teacher> getTeachers()
	{
		return teacherService.getTeachers();
	}

	@PostMapping("/teachers")
	public Teacher addTeacher(@RequestBody Teacher theTeacher)
	{
		teacherService.saveTeacher(theTeacher);
		return theTeacher;
	}


	@DeleteMapping("/teachers/{teacherId}")
	public String deleteTeacher(@PathVariable int teacherId)
	{
		teacherService.deleteTeacher(teacherId);
		return "deleted Sucessfully";
	}

	@DeleteMapping("/teachers/{teacherId}/{courseId}")
	public String deleteTeacherCourse(@PathVariable int teacherId, @PathVariable int courseId)
	{
		teacherService.deleteTeacherCourse(teacherId,courseId);

		return "deleted";
	}
	
	@GetMapping("/teachers/students/{teacherId}/{courseId}")
	public List<Student> getCourseStudents(@PathVariable int teacherId,@PathVariable int courseId)
	{

		return teacherService.getCourseStudents(teacherId,courseId);

	}
	
	///Questions Sections
	@GetMapping("questions")
	public List<Question> getQuestions()
	{
		return questionService.getQuestions();
	}

	@PostMapping("/questions")
	public Question saveQuestion(@RequestBody Question theQuestion)
	{
		questionService.addQuestion(theQuestion);
		return theQuestion;	
	}

	@DeleteMapping("/questions/{questionId}")
	public String deleteQuestion(@PathVariable int questionId)
	{
		questionService.deleteQuestion( questionId);
		return "deleted";
	}

	
	@GetMapping("/questions/{courseId}")
	public List<Question> getQuestionsByCourse(@PathVariable int courseId)
	{
		return questionService.getCourseQuestions(courseId);
	}


	//Test-Section /////////////////////

	@GetMapping("/test/{id}")
	public Test getTest(@PathVariable int id) {
		
		return testService.getTest(id);
	}

	@PostMapping("/test")
	@Transactional
	public Test saveTest(@RequestBody Test test) {
		return  testService.saveTest(test);
	}

	@GetMapping("/testResult/{studentId}/{teacherId}")
	public TestResult getTestResult(@PathVariable int studentId,@PathVariable int teacherId) {

		return testService.getTestResult(studentId,teacherId);
	}
	
	@PostMapping("/testResult")
	public TestResult saveTestResult(@RequestBody SubmitTestVO submitTestVO) {
		
		return testService.saveTestResult(submitTestVO);
	}

	@PostMapping("/generate-test")
	public Test generateTest(@RequestBody TestQuestionRequestVO testQuestionRequestVO) {
		
		return testService.generateTest(testQuestionRequestVO);
	}

	@GetMapping("/test-question/{testId}")
	public List<Question> getQuestionsForTest(@PathVariable int testId) {

		return testService.getQuestionsForTest(testId);
		 
	}

	//Course Section/////////////////////
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course theCourse)
	{
		courseService.addCourse(theCourse);
		return theCourse;
	}


	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return courseService.showCourses();
	}

	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable int courseId)
	{
		courseService.deleteCourse(courseId);
		return "deleted Sucessfully";
	}

}

package com.spring_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_project.entity.Course;
import com.spring_project.entity.Option;
import com.spring_project.entity.Question;
import com.spring_project.entity.Student;
import com.spring_project.entity.Teacher;
import com.spring_project.service.CourseService;
import com.spring_project.service.StudentService;
import com.spring_project.service.TeacherService;


@RequestMapping("/api")
@RestController
public class TheRestController {
	@Autowired
	StudentService studentService;

	@Autowired
	TeacherService teacherService;

	@Autowired
	CourseService courseService;

	// Student Section 	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student theStudent)
	{
		theStudent.setId(0);
		studentService.saveStudent(theStudent);
		return theStudent;
	}


	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return studentService.getStudents();
	}

	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student theStudent)
	{

		studentService.saveStudent(theStudent);
		return theStudent;
	}

	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId)
	{
		studentService.deleteStudent(studentId);
		return "deleted Sucessfully";
	}

	@PostMapping("/students/{studentId}/{courseId}")
	public String addStudentCourse(@PathVariable int studentId,@PathVariable int courseId)
	{

		studentService.addStudentCourse(studentId,courseId);
		return "added";
	}


	@DeleteMapping("/students/{studentId}/{courseId}")
	public String deleteStudentCourse(@PathVariable int studentId, @PathVariable int courseId)
	{
		studentService.deleteStudentCourse(studentId,courseId);

		return "deleted";
	}

	@GetMapping("/teachers")
	public List<Teacher> getTeachers()
	{
		return teacherService.getTeachers();
	}

	@PostMapping("/teachers")
	public Teacher addTeacher(@RequestBody Teacher theTeacher)
	{
		theTeacher.setId(0);
		teacherService.saveTeacher(theTeacher);
		return theTeacher;
	}
	@PutMapping("/teachers")
	public Teacher updateTeacher(@RequestBody Teacher theTeacher)
	{
		//theTeacher.setId(0);
		teacherService.saveTeacher(theTeacher);
		return theTeacher;
	}


	@DeleteMapping("/teachers/{teacherId}")
	public String deleteTeacher(@PathVariable int teacherId)
	{
		teacherService.deleteTeacher(teacherId);
		return "deleted Sucessfully";
	}


	@PostMapping("/teachers/{teacherId}/{courseId}")
	public String addTeacherCourse(@PathVariable int teacherId, @PathVariable int courseId)
	{
		teacherService.deleteTeacherCourse(teacherId,courseId);

		return "deleted";
	}

	@DeleteMapping("/teachers/{teacherId}/{courseId}")
	public String deleteTeacherCourse(@PathVariable int teacherId, @PathVariable int courseId)
	{
		teacherService.deleteTeacherCourse(teacherId,courseId);

		return "added";
	}

	@GetMapping("/teachers/students/{teacherId}/{courseId}")
	public List<Student> getCourseStudents(@PathVariable int teacherId,@PathVariable int courseId)
	{

		return teacherService.getCourseStudents(teacherId,courseId);

	}

	@GetMapping("/teachers/questions")
	public List<Question> getQuestions()
	{
		
		return teacherService.getQuestions();
		
	}

	@PostMapping("/teachers/questions")
	public Question addQuestion(@RequestBody Question theQuestion)

	{
		theQuestion.setId(0);
		teacherService.addQuestion(theQuestion);

		return theQuestion;	
	}
	
	@DeleteMapping("/teachers/questions/{questionId}")
	public String deleteQuestion(@PathVariable int questionId)
	{
		teacherService.deleteQuestion( questionId);
		return "deleted";
	}
	
	@GetMapping("/teachers/questions/{courseId}")
	public List<Question> getCourseQuestions(@PathVariable int courseId)
	{
		
		return teacherService.getCourseQuestions(courseId);
	}
	

	//Course Section/////////////////////


	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course theCourse)
	{
		theCourse.setId(0);
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

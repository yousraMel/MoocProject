package com.inti.formation.webServices;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Course;
import com.inti.formation.entities.Quiz;
import com.inti.formation.iservices.IChapterService;
import com.inti.formation.iservices.ICourseService;


@RestController

@RequestMapping("/courseApi")
@CrossOrigin(origins="*")
public class CourseWebService {
	
	@Autowired
	private ICourseService courseService;
	@Autowired
	private IChapterService chapterService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Course saveOrUpdate(@RequestBody @Valid Course course) {
		
		
		
		return courseService.saveOrUpdateCourse(course);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Course update(@RequestBody Course c) {
		return courseService.saveOrUpdateCourse(c);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Course getById(@PathVariable("id") Long id) { 
		return courseService.getByIdCourse(id);
	}

	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		courseService.deleteCourse(id);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Course> findAll(){
		return courseService.getAllCourse();
	}
	
	@RequestMapping(value="/courseNote", method=RequestMethod.GET)
	public Course getCourseNote(@PathVariable("id") Long idCourse) {
		courseService.getByIdCourse(idCourse).setCourseNote(courseService.getCourseNote(idCourse));
		return  courseService.getByIdCourse(idCourse);
	}

}

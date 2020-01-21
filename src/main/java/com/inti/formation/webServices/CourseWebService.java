package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Course;
import com.inti.formation.iservices.ICourseService;


@RestController
@RequestMapping("/courseApi")
@CrossOrigin(origins = "*")
public class CourseWebService {
	
	@Autowired
	private ICourseService service;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Course saveOrUpdate(@RequestBody Course c) {
		return service.saveOrUpdateCourse(c);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Course update(@RequestBody Course c) {
		return service.saveOrUpdateCourse(c);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Course getById(@PathVariable("id") Long id) { 
		return service.getByIdCourse(id);
	}

	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.deleteCourse(id);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Course> findAll(){
		return service.getAllCourse();
	}
	
	@RequestMapping(value="/courseNote", method=RequestMethod.GET)
	public Course getCourseNote(@PathVariable("id") Long idCourse) {
		service.getByIdCourse(idCourse).setCourseNote(service.getCourseNote(idCourse));
		return  service.getByIdCourse(idCourse);
	}

}

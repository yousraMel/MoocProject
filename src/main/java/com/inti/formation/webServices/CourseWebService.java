package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entites.Course;
import com.inti.formation.iservice.ICourseService;

@RestController
@RequestMapping("/CourseApi")
@CrossOrigin("*")
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

	@RequestMapping(value = "/get/{idCourse}", method = RequestMethod.GET)
	public Course getById(@PathVariable("idCourse") Long idCourse) { 
		return service.getByIdCourse(idCourse);
	}

	@RequestMapping(value="/delete/{idCourse}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("idCourse") Long idCourse) {
		service.deleteCourse(idCourse);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Course>findAll() {
		return service.getAllCourse();
	}
}

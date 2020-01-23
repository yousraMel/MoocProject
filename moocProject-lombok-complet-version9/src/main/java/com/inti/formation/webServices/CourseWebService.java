package com.inti.formation.webServices;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.formation.entities.Course;
import com.inti.formation.exeptions.ResponseHandler;
import com.inti.formation.iservices.IChapterService;
import com.inti.formation.iservices.ICourseService;
import com.inti.formation.iservices.IFileCourseService;


@RestController

@RequestMapping("/courseApi")
@CrossOrigin(origins="*")
public class CourseWebService {
	
	@Autowired
	private ICourseService courseService;
	@Autowired
	private IChapterService chapterService;
	@Autowired
    private  IFileCourseService FILE_SERVICE;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Course saveOrUpdate(@RequestBody @Valid Course course) {
		
		
		
		return courseService.saveOrUpdateCourse(course);
	}

	@RequestMapping(value = "/update/{idCourse}", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	  @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	public ResponseHandler updateCourse(@RequestBody Course c,@PathVariable("idCourse") Long idCourse, @RequestParam("file") MultipartFile file) throws IOException  {
		courseService.saveOrUpdateCourse(c);
		return new ResponseHandler(HttpStatus.OK, FILE_SERVICE.storeCourse(file, idCourse));
		
	
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

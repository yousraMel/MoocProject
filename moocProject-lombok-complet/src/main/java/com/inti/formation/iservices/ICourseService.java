package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Course;

public interface ICourseService {

	public Course saveOrUpdateCourse(Course c);
	public void deleteCourse(Long id);
	public Course getByIdCourse(Long id);
	public List<Course> getAllCourse();
	
}

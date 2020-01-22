package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entites.Course;

public interface ICourseService {
	public Course saveOrUpdateCourse(Course c);
	public void deleteCourse(Long id);
	public Course getByIdCourse(Long id);
	public List<Course> getAllCourse();
	
}

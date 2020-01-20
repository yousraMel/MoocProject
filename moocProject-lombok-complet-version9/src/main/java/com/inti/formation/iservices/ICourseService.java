package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Course;
import com.inti.formation.entities.CourseFile;
import com.inti.formation.entities.Image;

public interface ICourseService {

	public Course saveOrUpdateCourse(Course c);
	public void deleteCourse(Long idCourse);
	public Course getByIdCourse(Long idCourse);
	public List<Course> getAllCourse();
	 public void mergeNewCourseFiles(Long idCourse, List<CourseFile> Courses);
	public double getCourseNote(Long idCourse);
	
}

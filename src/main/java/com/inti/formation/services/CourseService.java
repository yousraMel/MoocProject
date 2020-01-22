package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entites.Course;
import com.inti.formation.iservice.ICourseService;
 
import com.inti.formation.repositories.ICourseRepository;

@Service
public class CourseService implements ICourseService  {
	@Autowired
	private ICourseRepository repo;

	@Override
	public Course saveOrUpdateCourse(Course c) {
		return repo.save(c);
	}

	@Override
	public void deleteCourse(Long id) {
		repo.delete(repo.getOne(id));
	}

	@Override
	public Course getByIdCourse(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Course> getAllCourse() {
		return repo.findAll();
}
}
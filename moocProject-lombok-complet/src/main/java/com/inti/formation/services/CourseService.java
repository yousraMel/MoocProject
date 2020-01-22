package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Course;
import com.inti.formation.iservices.ICourseService;
import com.inti.formation.repositories.CourseRepository;

@Service
public class CourseService implements ICourseService {

	@Autowired
	private CourseRepository repo;

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

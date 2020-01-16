package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Course;
import com.inti.formation.entities.Note;
import com.inti.formation.iservices.ICourseService;
import com.inti.formation.iservices.INoteService;
import com.inti.formation.repositories.ICourseRepository;

@Service
public class CourseService implements ICourseService {

	@Autowired
	private ICourseRepository repo;
	
	@Autowired
	private INoteService noteService;

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

	@Override
	public double getCourseNote(Long id) {
		List<Note> notes= noteService.findByCourse(repo.getOne(id));
		double note = 0;
		for (int i = 0; i < notes.size() ; i++) {
			note += notes.get(i).getNote();
		}
		return note/ noteService.getNbrOfNotesByCourse(repo.getOne(id));
	}

}

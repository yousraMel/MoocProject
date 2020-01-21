package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Course;
import com.inti.formation.entities.Note;
import com.inti.formation.iservices.INoteService;
import com.inti.formation.repositories.INoteRepository;

@Service
public class NoteService implements INoteService {

	@Autowired
	private INoteRepository repo;
	
	@Override
	public Note saveOrUpdateNote(Note note) {
		return repo.save(note);
	}

	@Override
	public void deleteNote(Long idNote) {
		repo.deleteById(idNote);
	}

	@Override
	public Note getByIdNote(Long idNote) {
		return repo.findById(idNote).get();
	}

	@Override
	public List<Note> getAllNotes() {
		return repo.findAll();
	}

	@Override
	public List<Note> findByCourse(Course course) {
		return repo.findByCourse(course);
	}

	@Override
	public int getNbrOfNotesByCourse(Course course) {
		return repo.nbrOfNotesByCourse(course);
	}

}

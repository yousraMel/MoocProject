package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Course;
import com.inti.formation.entities.Note;

public interface INoteService {
	
	public Note saveOrUpdateNote(Note note);
	public void deleteNote (Long idNote);
	public Note getByIdNote(Long idNote);
	public List<Note> getAllNotes();
	public List<Note> findByCourse(Course course);
	public int getNbrOfNotesByCourse(Course course);

}

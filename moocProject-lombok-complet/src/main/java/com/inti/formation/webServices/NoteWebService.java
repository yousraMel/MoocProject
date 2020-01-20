package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Note;
import com.inti.formation.iservices.INoteService;

@RestController
@RequestMapping(value="/note")
public class NoteWebService {
	
	@Autowired
	private INoteService service;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Note saveOrUpdate(@RequestBody Note note) {
		return service.saveOrUpdateNote(note);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Note update(@RequestBody Note note ){
		return service.saveOrUpdateNote(note);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Note getById(@PathVariable("id") Long idNote) { 
		return service.getByIdNote(idNote);
	}

	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long idNote) {
		service.deleteNote(idNote);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Note> findAll(){
		return service.getAllNotes();
	}
	

}

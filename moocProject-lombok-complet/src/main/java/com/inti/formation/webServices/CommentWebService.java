package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Comment;
import com.inti.formation.iservices.ICommentService;

@RestController
@RequestMapping("/apiComment")
@CrossOrigin(origins = "*")
public class CommentWebService {
	
	@Autowired
	private ICommentService service;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Comment saveOrUpdate(@RequestBody Comment c) {
		return service.saveOrUpdateComment(c);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Comment update(@RequestBody Comment c) {
		return service.saveOrUpdateComment(c);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Comment getById(@PathVariable("id") Long id) { 
		return service.getByIdComment(id);
	}

	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.deleteComment(id);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Comment> findAll() {
		return service.getAllComment();
	}

}
